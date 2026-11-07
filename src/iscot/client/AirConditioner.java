package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.AreaTemperatureOrderEvent;

public class AirConditioner {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Ar condicionado em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            ACIcon ac = new ACIcon();
            ActionHistory historico = new ActionHistory();
            painel.add(ac, BorderLayout.CENTER);
            painel.add(historico, BorderLayout.SOUTH);
            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.pack();
            janela.setMinimumSize(janela.getSize());
            janela.setVisible(true);

            final AreaTemperatureOrderEvent[] demo = {
                    new AreaTemperatureOrderEvent(area, AirConditioningMode.Frio, 20),
                    new AreaTemperatureOrderEvent(area, AirConditioningMode.Aquecimento, 24),
                    new AreaTemperatureOrderEvent(area, AirConditioningMode.Desligado, 22)
            };
            final int[] i = { 0 };
            Timer timer = new Timer(3000, e -> {
                aplicarOrdem(demo[i[0]], ac, historico);
                i[0]++;
                if (i[0] == demo.length)
                    ((Timer) e.getSource()).stop();
            });
            timer.setInitialDelay(2000);
            timer.start();
        }
    }

    private static void aplicarOrdem(AreaTemperatureOrderEvent ev, ACIcon ac, ActionHistory historico) {
        System.out.println("RECEBIDO PELO ATUADOR: " + ev);
        ac.setModo(ev.getMode());
        if (ev.getMode() == AirConditioningMode.Desligado) {
            historico.registar("Ar condicionado desligado");
        } else {
            ac.setTemperatura(ev.getTargetTemperature());
            historico.registar("Ar condicionado em " + ev.getMode()
                    + " a " + ev.getTargetTemperature() + " °C");
        }
    }
}