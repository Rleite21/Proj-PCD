package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.HumiditySensorEvent;

public class HumiditySensor {

	/**
	 * 
	 * @param server    address and port
	 * @param roomName: string
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
		} else {

			Areas area = Areas.valueOf(args[2]);

			JFrame janela = new JFrame("Humidade em " + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl = new SensorControl("☀", "Humidade - " + area, "%",
					0, 100, 1, 50,
					valor -> {
						HumiditySensorEvent evento = new HumiditySensorEvent(area, valor);
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