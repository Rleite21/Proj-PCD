package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.AreaLightingOrderEvent;

public class LightActuator {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Luz em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            LightIcon luz = new LightIcon();
            ActionHistory historico = new ActionHistory();
            painel.add(luz, BorderLayout.CENTER);
            painel.add(historico, BorderLayout.SOUTH);
            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.pack();
            janela.setMinimumSize(janela.getSize());
            janela.setVisible(true);

            final AreaLightingOrderEvent[] demo = {
                    new AreaLightingOrderEvent(area, true),
                    new AreaLightingOrderEvent(area, false),
                    new AreaLightingOrderEvent(area, true)
            };
            final int[] i = { 0 };
            Timer timer = new Timer(3000, e -> {
                aplicarOrdem(demo[i[0]], luz, historico);
                i[0]++;
                if (i[0] == demo.length)
                    ((Timer) e.getSource()).stop();
            });
            timer.setInitialDelay(2000);
            timer.start();
        }
    }

    private static void aplicarOrdem(AreaLightingOrderEvent ev, LightIcon luz, ActionHistory historico) {
        System.out.println("RECEBIDO PELO ATUADOR: " + ev);
        luz.setLigada(ev.isState());
        historico.registar(ev.isState() ? "Lâmpada ligada" : "Lâmpada desligada");
    }
}