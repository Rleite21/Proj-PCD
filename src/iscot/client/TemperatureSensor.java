package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.TemperatureSensorEvent;

public class TemperatureSensor {

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Temperatura em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            SensorControl sensorControl = new SensorControl("🌡", "Temperatura - " + area, "°C",
                    0, 40, 0.5, 22,
                    valor -> {
                        TemperatureSensorEvent evento = new TemperatureSensorEvent(area, valor);
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