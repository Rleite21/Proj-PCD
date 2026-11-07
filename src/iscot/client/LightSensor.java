package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.LightSensorEvent;

public class LightSensor {

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {

            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Luminosidade em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            SensorControl sensorControl = new SensorControl("☀", "Luminosidade - " + area, "lux",
                    0, 1000, 10, 500,
                    valor -> {
                        LightSensorEvent evento = new LightSensorEvent(area, valor);
                        System.out.println(evento);
                    });
            painel.add(sensorControl, BorderLayout.CENTER);
            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.setMinimumSize(janela.getSize());
            janela.pack();
            janela.setVisible(true);
        }
    }
}