package emulator;

import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

public class Keyboard {
    boolean[] isPressed;
    int[] key;
    int[] pressedKey;

    public Keyboard(JPanel panel, int[] key, boolean[] isPressed, int[] pressedKey) {
        this.key = key;
        this.isPressed = isPressed;
        this.pressedKey = pressedKey;

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "Pressed1");
        panel.getActionMap().put("Pressed1", new Action1());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "Pressed2");
        panel.getActionMap().put("Pressed2", new Action2());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "Pressed3");
        panel.getActionMap().put("Pressed3", new Action3());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("4"), "Pressed4");
        panel.getActionMap().put("Pressed4", new Action4());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"), "PressedQ");
        panel.getActionMap().put("PressedQ", new ActionQ());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "PressedW");
        panel.getActionMap().put("PressedW", new ActionW());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("E"), "PressedE");
        panel.getActionMap().put("PressedE", new ActionE());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("R"), "PressedR");
        panel.getActionMap().put("PressedR", new ActionR());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "PressedA");
        panel.getActionMap().put("PressedA", new ActionA());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "PressedS");
        panel.getActionMap().put("PressedS", new ActionS());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "PressedD");
        panel.getActionMap().put("PressedD", new ActionD());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F"), "PressedF");
        panel.getActionMap().put("PressedF", new ActionF());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Z"), "PressedZ");
        panel.getActionMap().put("PressedZ", new ActionZ());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("X"), "PressedX");
        panel.getActionMap().put("PressedX", new ActionX());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("C"), "PressedC");
        panel.getActionMap().put("PressedC", new ActionC());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("V"), "PressedV");
        panel.getActionMap().put("PressedV", new ActionV());

        //released actions

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released 1"), "Released1");
        panel.getActionMap().put("Released1", new Action1Release());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released 2"), "Released2");
        panel.getActionMap().put("Released2", new Action2Release());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released 3"), "Released3");
        panel.getActionMap().put("Released3", new Action3Release());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released 4"), "Released4");
        panel.getActionMap().put("Released4", new Action4Release());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released Q"), "ReleasedQ");
        panel.getActionMap().put("ReleasedQ", new ActionQRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "ReleasedW");
        panel.getActionMap().put("ReleasedW", new ActionWRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released E"), "ReleasedE");
        panel.getActionMap().put("ReleasedE", new ActionERelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released R"), "ReleasedR");
        panel.getActionMap().put("ReleasedR", new ActionRRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "ReleasedA");
        panel.getActionMap().put("ReleasedA", new ActionARelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "ReleasedS");
        panel.getActionMap().put("ReleasedS", new ActionSRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "ReleasedD");
        panel.getActionMap().put("ReleasedD", new ActionDRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released F"), "ReleasedF");
        panel.getActionMap().put("ReleasedF", new ActionFRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released Z"), "ReleasedZ");
        panel.getActionMap().put("ReleasedZ", new ActionZRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released X"), "ReleasedX");
        panel.getActionMap().put("ReleasedX", new ActionXRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released C"), "ReleasedC");
        panel.getActionMap().put("ReleasedC", new ActionCRelease());

        panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released V"), "ReleasedV");
        panel.getActionMap().put("ReleasedV", new ActionVRelease());


    }

    class Action1 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x1] = 1;
            pressedKey[0] = 0x1;
        }
    }

    class Action2 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x2] = 1;
            pressedKey[0] = 0x2;
        }
    }

    class Action3 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x3] = 1;
            pressedKey[0] = 0x3;
        }
    }

    class Action4 extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xC] = 1;
            pressedKey[0] = 0xC;
        }
    }

    class ActionQ extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x4] = 1;
            pressedKey[0] = 0x4;
        }
    }

    class ActionW extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x5] = 1;
            pressedKey[0] = 0x5;
        }
    }

    class ActionE extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x6] = 1;
            pressedKey[0] = 0x6;
        }
    }

    class ActionR extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xD] = 1;
            pressedKey[0] = 0xD;
        }
    }

    class ActionA extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x7] = 1;
            pressedKey[0] = 0x7;
        }
    }

    class ActionS extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x8] = 1;
            pressedKey[0] = 0x8;
        }
    }

    class ActionD extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x9] = 1;
            pressedKey[0] = 0x9;
        }
    }

    class ActionF extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xE] = 1;
            pressedKey[0] = 0xE;
        }
    }

    class ActionZ extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xA] = 1;
            pressedKey[0] = 0xA;
        }
    }

    class ActionX extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0x0] = 1;
            pressedKey[0] = 0x0;
        }
    }

    class ActionC extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xB] = 1;
            pressedKey[0] = 0xB;
        }
    }

    class ActionV extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = true;
            key[0xF] = 1;
            pressedKey[0] = 0xF;
        }
    }

    // Now for released actions

    class Action1Release extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x1] = 0;
            pressedKey[0] = -1;
        }
    }

    class Action2Release extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x2] = 0;
            pressedKey[0] = -1;
        }
    }

    class Action3Release extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x3] = 0;
            pressedKey[0] = -1;
        }
    }

    class Action4Release extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xC] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionQRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x4] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionWRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x5] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionERelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x6] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionRRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xD] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionARelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x7] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionSRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x8] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionDRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x9] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionFRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xE] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionZRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xA] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionXRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0x0] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionCRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xB] = 0;
            pressedKey[0] = -1;
        }
    }

    class ActionVRelease extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            isPressed[0] = false;
            key[0xF] = 0;
            pressedKey[0] = -1;
        }
    }
}
