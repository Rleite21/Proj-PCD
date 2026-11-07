package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import iscot.client.gui.IrrigationIcon;
import iscot.enums.Areas;
import iscot.events.AreaIrrigationOrderEvent;

public class IrrigationActuator {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
		} else {
			Areas area = Areas.valueOf(args[2]);

			JFrame janela = new JFrame("Rega em " + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout());
			IrrigationIcon rega = new IrrigationIcon();
			ActionHistory historico = new ActionHistory();
			painel.add(rega, BorderLayout.CENTER);
			painel.add(historico, BorderLayout.SOUTH);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.pack();
			janela.setMinimumSize(janela.getSize());
			janela.setVisible(true);

			final AreaIrrigationOrderEvent[] demo = {
					new AreaIrrigationOrderEvent(area, true),
					new AreaIrrigationOrderEvent(area, false),
					new AreaIrrigationOrderEvent(area, true)
			};
			final int[] i = { 0 };
			Timer timer = new Timer(3000, e -> {
				aplicarOrdem(demo[i[0]], rega, historico);
				i[0]++;
				if (i[0] == demo.length)
					((Timer) e.getSource()).stop();
			});
			timer.setInitialDelay(2000);
			timer.start();
		}
	}

	private static void aplicarOrdem(AreaIrrigationOrderEvent ev, IrrigationIcon rega, ActionHistory historico) {
		System.out.println("RECEBIDO PELO ATUADOR: " + ev);
		rega.setAtiva(ev.isState());
		historico.registar(ev.isState() ? "Rega ligada" : "Rega desligada");
	}
}