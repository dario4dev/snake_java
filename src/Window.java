import javax.swing.JFrame;
import java.awt.Dimension;

    public class Window {

        final JFrame mframe;

        public Window(final Dimension screenSize, final String title, final Game game) {
            mframe = new JFrame(title);

            mframe.setPreferredSize(screenSize);
            mframe.setMaximumSize(screenSize);
            mframe.setMinimumSize(screenSize);

            mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mframe.setResizable(false);
            mframe.setLocationRelativeTo(null);
            mframe.add(game);
            mframe.setVisible(true);
    }
}
