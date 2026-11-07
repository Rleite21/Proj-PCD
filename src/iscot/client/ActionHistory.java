package iscot.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ActionHistory extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final DefaultListModel<String> modelo = new DefaultListModel<>();

    public ActionHistory() {
        super(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Histórico de ações"));
        JScrollPane scroll = new JScrollPane(new JList<>(modelo));
        scroll.setPreferredSize(new Dimension(280, 120));
        add(scroll, BorderLayout.CENTER);
    }

    /** Regista uma ação com a hora atual. Pode ser chamado de qualquer thread. */
    public void registar(String descricao) {
        final String linha = descricao + " - " + LocalTime.now().format(FORMATO);
        SwingUtilities.invokeLater(() -> modelo.addElement(linha));
    }
}