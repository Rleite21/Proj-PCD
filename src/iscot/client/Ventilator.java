package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import iscot.client.gui.VentilatorIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.AreaVentilationOrderEvent;

public class Ventilator {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
		} else {

			Areas area = Areas.valueOf(args[2]);

			JFrame janela = new JFrame("Ventilador em " + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout());
			VentilatorIcon ventilator = new VentilatorIcon();
			ActionHistory historico = new ActionHistory();
			painel.add(ventilator, BorderLayout.CENTER);
			painel.add(historico, BorderLayout.SOUTH);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.pack();
			janela.setMinimumSize(janela.getSize());
			janela.setVisible(true);

			final AreaVentilationOrderEvent[] demo = {
					new AreaVentilationOrderEvent(area, AirConditioningMode.Ventilação),
					new AreaVentilationOrderEvent(area, AirConditioningMode.Desligado),
					new AreaVentilationOrderEvent(area, AirConditioningMode.Ventilação)
			};
			final int[] i = { 0 };
			Timer timer = new Timer(3000, e -> {
				aplicarOrdem(demo[i[0]], ventilator, historico);
				i[0]++;
				if (i[0] == demo.length)
					((Timer) e.getSource()).stop();
			});
			timer.setInitialDelay(2000);
			timer.start();
		}
	}

	private static void aplicarOrdem(AreaVentilationOrderEvent ev, VentilatorIcon ventilator, ActionHistory historico) {
		System.out.println("RECEBIDO PELO ATUADOR: " + ev);
		boolean ligar = ev.getMode() == AirConditioningMode.Ventilação;
		ventilator.setLigado(ligar);
		historico.registar(ligar ? "Ventilador ligado" : "Ventilador desligado");
	}
}