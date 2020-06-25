package info.stepanoff.testing.assertj;

import com.google.common.collect.SetMultimap;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayDeque;
import java.util.Stack;
import info.stepanoff.testing.assertj.AhoCorasick;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;

public class SampleFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField MainStr;
    private JTextField SubStr;
    private JTextField Res;

    JButton buttonMainStr = new JButton("Добавить");
    JButton buttonSubStr = new JButton("Добавить");
    JButton buttonSearch = new JButton("Результат");
    JButton buttonSS = new JButton("Добавить");
    JButton buttonCancel = new JButton("Очистить");

    JLabel labelRes = new JLabel("Результат", JLabel.LEFT);
    JLabel labelMain = new JLabel("Текст", JLabel.LEFT);
    JLabel labelSub = new JLabel("Поисковая строка", JLabel.LEFT);
    List<Character[]> patterns = Stream.of("")
            .map(s -> ArrayUtils.toObject(s.toCharArray()))
            .collect(Collectors.toList());
    int index = 0;

    public SampleFrame() {
        patterns.remove(0);
        JPanel panel = new JPanel(new GridLayout(9, 1));
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonSearch.setEnabled(false);
        MainStr = new JTextField(20);
        MainStr.setName("MainStr");
        MainStr.setLocation(1, 1);
        MainStr.setActionCommand("dd");

        SubStr = new JTextField(20);
        SubStr.setName("SubStr");;

        Res = new JTextField(20);
        Res.setName("Res");
        Res.setEditable(false);

        buttonSearch.setName("buttonSearch");
        buttonSearch.setActionCommand("BS");;
        buttonSearch.addActionListener(this);

        buttonSS.setName("buttonSS");
        buttonSS.setActionCommand("BVE");;
        buttonSS.addActionListener(this);
        
        buttonCancel.setName("buttonCancel");
        buttonCancel.setActionCommand("BC");;
        buttonCancel.addActionListener(this);

        panel.add(labelMain);
        panel.add(MainStr);
        panel.add(labelSub);
        panel.add(SubStr);
        panel.add(buttonSS);

        panel.add(buttonSearch);
        panel.add(labelRes);
        panel.add(Res);
        panel.add(buttonCancel);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public SampleFrame(String name) {
        this();
        setName(name);
    }

    public static String removeCharAt(String s, char c) {
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
        }
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if (MainStr.getText().trim().length()>0) {
            buttonSearch.setEnabled(true);
        } else {
            buttonSearch.setEnabled(false);
        }
        
        if (ee.getActionCommand() == "BVE") {
            patterns.add(index, ArrayUtils.toObject(SubStr.getText().toCharArray()));
            index++;
            SubStr.setText("");
        } else if (ee.getActionCommand() == "BS") {
            String str = MainStr.getText();
            Character[] text = ArrayUtils.toObject(str.toCharArray());

            AhoCorasick<Character> ac = new AhoCorasick<>(patterns);
            SetMultimap<Integer, Integer> result = ac.search(text, false);
            Res.setText(result.toString());
        }
        else if(ee.getActionCommand() == "BC"){
            MainStr.setText("");
            SubStr.setText("");
            Res.setText("");
            buttonSearch.setEnabled(false);
            patterns = Stream.of("")
            .map(s -> ArrayUtils.toObject(s.toCharArray()))
            .collect(Collectors.toList());
            patterns.remove(0);
            index=0;
        }
    }

}
