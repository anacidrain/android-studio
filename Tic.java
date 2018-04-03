import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Tic extends JFrame {

    public boolean X = true;
    public boolean O = true;
    public boolean WindowA1 = false;
    public boolean WindowA2 = false;
    public boolean WindowA3 = false;
    public boolean WindowB1 = false;
    public boolean WindowB2 = false;
    public boolean WindowB3 = false;
    public boolean WindowC1 = false;
    public boolean WindowC2 = false;
    public boolean WindowC3 = false;

    public JButton A1;
    public JButton A2;
    public JButton A3;
    public JButton B1;
    public JButton B2;
    public JButton B3;
    public JButton C1;
    public JButton C2;
    public JButton C3;
    public JButton GameAgain;
    public JLabel Label;




    public Tic() {
        initComponents();
    }

    private boolean Turn(){

        if(X){
            X = false;
            return true;
        }
        if(!X){
            X = true;
            return false;
        }
        return false; }

    private void win() {
// проверка на победу по Х
        if ((A1.getText().equals("X") && A2.getText().equals("X") && A3.getText().equals("X")) ||
                (B1.getText().equals("X") && B2.getText().equals("X") && B3.getText().equals("X")) ||
                (C1.getText().equals("X") && C2.getText().equals("X") && C3.getText().equals("X")) ||
                (A1.getText().equals("X") && B1.getText().equals("X") && C1.getText().equals("X")) ||
                (A2.getText().equals("X") && B2.getText().equals("X") && C2.getText().equals("X")) ||
                (A3.getText().equals("X") && B3.getText().equals("X") && C3.getText().equals("X")) ||
                (A1.getText().equals("X") && B2.getText().equals("X") && C3.getText().equals("X")) ||
                (A3.getText().equals("X") && B2.getText().equals("X") && C1.getText().equals("X"))) {
// если хоть одно из условий выполнилось, игра заканчивается, кнопки все становятся "нажатыми"
            WindowA1 = true;
            WindowA2 = true;
            WindowA3 = true;
            WindowB1 = true;
            WindowB2 = true;
            WindowB3 = true;
            WindowC1 = true;
            WindowC2 = true;
            WindowC3 = true;
// игрок Х объявялется победителем
            Label.setText("Winner X");
//появляется кнопка GameAgain






            return;    }
// тоже самое с О
        if ((A1.getText().equals("O") && A2.getText().equals("O") && A3.getText().equals("O")) ||
                (B1.getText().equals("O") && B2.getText().equals("O") && B3.getText().equals("O")) ||
                (C1.getText().equals("O") && C2.getText().equals("O") && C3.getText().equals("O")) ||
                (A1.getText().equals("O") && B1.getText().equals("O") && C1.getText().equals("O")) ||
                (A2.getText().equals("O") && B2.getText().equals("O") && C2.getText().equals("O")) ||
                (A3.getText().equals("O") && B3.getText().equals("O") && C3.getText().equals("O")) ||
                (A1.getText().equals("O") && B2.getText().equals("O") && C3.getText().equals("O")) ||
                (A3.getText().equals("O") && B2.getText().equals("O") && C1.getText().equals("O"))) {

            A1.setBackground(new java.awt.Color(102, 255, 51));
            A2.setBackground(new java.awt.Color(102, 255, 51));
            A3.setBackground(new java.awt.Color(102, 255, 51));
            B1.setBackground(new java.awt.Color(102, 255, 51));
            B2.setBackground(new java.awt.Color(102, 255, 51));
            B3.setBackground(new java.awt.Color(102, 255, 51));
            C1.setBackground(new java.awt.Color(102, 255, 51));
            C2.setBackground(new java.awt.Color(102, 255, 51));
            C3.setBackground(new java.awt.Color(102, 255, 51)); // закрашивает клетки после победы (по желанию сделаю для О)

            WindowA1 = true;
            WindowA2 = true;
            WindowA3 = true;
            WindowB1 = true;
            WindowB2 = true;
            WindowB3 = true;
            WindowC1 = true;
            WindowC2 = true;
            WindowC3 = true; // после победы О кнопки больше не нажимаются, игра прекращается

            Label.setText("Winner O");
            // появляется кнопка GameAgain

            return; }
        //в случае, если никто не выйграл идет проверка на ничью.
        CheckifDraw();
    }



    public void CheckifDraw(){

        if(A1.getText().equals("O") || A1.getText().equals("X") &&
                A2.getText().equals("O") || A2.getText().equals("X") &&
                A3.getText().equals("O") || A3.getText().equals("X") &&
                B1.getText().equals("O") || B1.getText().equals("X") &&
                B2.getText().equals("O") || B2.getText().equals("X") &&
                B3.getText().equals("O") || B3.getText().equals("X") &&
                C1.getText().equals("O") || C1.getText().equals("X") &&
                C2.getText().equals("O") || C2.getText().equals("X") &&
                C3.getText().equals("O") || C3.getText().equals("X")){

            if(A1.getText().equals("") || A2.getText().equals("")
                    || A3.getText().equals("") || C1.getText().equals("")
                    || B1.getText().equals("") || C2.getText().equals("")
                    || B2.getText().equals("") || C3.getText().equals("")
                    || B3.getText().equals("")){

                return;            }

            A1.setText("");
            A2.setText("");
            A3.setText("");
            B1.setText("");
            B2.setText("");
            B3.setText("");
            C1.setText("");
            C2.setText("");
            C3.setText(""); // очищает клетки, после ничьей (по желанию сделаю для ничьей)

            Label.setText("DRAW!");

        }
    }

    private void initComponents() { // описание компонент игрового поля

        Label = new JLabel(); // выделяется свободное место для надписи
        A1 = new JButton(); // выделяются свободные метса для кнопок
        A2 = new JButton();
        A3 = new JButton();
        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        C1 = new JButton();
        C2 = new JButton();
        C3 = new JButton();
        GameAgain = new JButton("Game Again");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //чтобы можно было закрыть игровое окно
        setTitle("Tic Tac Toe"); // заголовок окна
        addMouseMotionListener(new MouseMotionAdapter() { // слушатель для мышки
            public void mouseMoved(MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new WindowAdapter() { // для того, чтобы получить события окна
            public void windowActivated(WindowEvent evt) { // переключается с одного окна на другое
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        Label.setFont(new Font("Times New Roman", 1, 55));
        Label.setForeground(new Color(255, 0, 0));
        getContentPane().add(Label);
        Label.setBounds(30, 100, 300, 100);

        A1.setFont(new Font("Times New Roman", 1, 80));
        A1.addMouseListener(new MouseAdapter() {  // получает события от нажатия мыши
            public void mouseClicked(MouseEvent evt) { // mouseClicked(MouseEvent e) вызывается когда кнопкой мыши щелкнули на компоненте
                A1MouseClicked(evt);                //MouseEvent вызывает соответствующий метод в объекте слушателя
            }
            public void mousePressed(MouseEvent evt) {
                A1MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                A1MouseReleased(evt);
            }
        });
        getContentPane().add(A1);
        A1.setBounds(0, 0, 100, 100);

        A2.setFont(new Font("Times new roman", 1, 86)); // Установка шрифта происходит при помощи метода setFont класса JLabel,
        A2.addMouseListener(new MouseAdapter() {                   // этому методу в качестве параметра передается объект Font
            public void mousePressed(MouseEvent evt) {
                A2MousePressed(evt); //MousePressed вызывается в случае нажатия на мышь
            }
            public void mouseReleased(MouseEvent evt) {
                A2MouseReleased(evt); // MouseReleased - при отпускании кнопки мыши
            }
        });
        getContentPane().add(A2);
        A2.setBounds(100, 0, 100,100);

        A3.setFont(new Font("Times new roman", 1, 86));
        A3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                A3MousePressed(evt);
            }
        });
        getContentPane().add(A3);
        A3.setBounds(200, 0, 100, 100);

        B1.setFont(new Font("Times new roman", 1, 86));
        B1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                B1MousePressed(evt);
            }
        });
        getContentPane().add(B1);
        B1.setBounds(0, 100, 100, 100);

        B2.setFont(new Font("Times new roman", 1, 86));
        B2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                B2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                B2MouseReleased(evt);
            }
        });
        getContentPane().add(B2);
        B2.setBounds(100, 100, 100, 100);

        B3.setFont(new Font("Times new roman", 1, 86));
        B3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                B3MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                B3MouseReleased(evt);
            }
        });
        getContentPane().add(B3);
        B3.setBounds(200, 100, 100, 100);

        C1.setFont(new Font("Times new roman", 1, 86));
        C1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                C1MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                C1MouseReleased(evt);
            }
        });
        getContentPane().add(C1);
        C1.setBounds(0, 200, 100, 100);

        C2.setFont(new Font("Times new roman", 1, 86));
        C2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                C2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                C2MouseReleased(evt);
            }
        });
        getContentPane().add(C2);
        C2.setBounds(100, 200, 100, 100);

        C3.setFont(new Font("Times new roman", 1, 86));
        C3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                C3MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                C3MouseReleased(evt);
            }
        });
        getContentPane().add(C3);
        C3.setBounds(200, 200, 100, 100);

        getContentPane().add(GameAgain);
        GameAgain.setFont(new Font("Times new roman", 1, 20));
        GameAgain.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                GameAgainMousePressed(evt);
            }
        });
        getContentPane().add(GameAgain);
        GameAgain.setBounds(40, 300, 200, 60    );




        pack();
    }

    private void A1MousePressed(MouseEvent evt) { // MouseEvent описывает изменение состояния ячеки, после  нажатия мышкой (cобытие, которое произошло после нажатия)
        win();
        if(!WindowA1){
            if(Turn()){
                A1.setText("X");
            }else{
                A1.setText("O");
            }
        }
        WindowA1 = true;
        win();
    }

    private void A2MousePressed(MouseEvent evt) {
        win();
        if(!WindowA2){
            if(Turn()){
                A2.setText("X");
            }else{
                A2.setText("O");
            }
        }
        WindowA2 = true;
        win();
    }

    private void A3MousePressed(MouseEvent evt) {
        win();
        if(!WindowA3){
            if(Turn()){
                A3.setText("X");
            }else{
                A3.setText("O");
            }
        }
        WindowA3 = true;
        win();
    }

    private void B1MousePressed(MouseEvent evt) {
        win();
        if(!WindowB1){
            if(Turn()){
                B1.setText("X");
            }else{
                B1.setText("O");
            }
        }
        WindowB1 = true;
        win();
    }

    private void B2MousePressed(MouseEvent evt) {
        win();
        if(!WindowB2){
            if(Turn()){
                B2.setText("X");
            }else{
                B2.setText("O");
            }
        }
        WindowB2 = true;
        win();
    }

    private void B3MousePressed(MouseEvent evt) {
        win();
        if(!WindowB3){
            if(Turn()){
                B3.setText("X");
            }else{
                B3.setText("O");
            }
        }
        WindowB3 = true;
        win();
    }

    private void C1MousePressed(MouseEvent evt) {
        win();
        if(!WindowC1){
            if(Turn()){
                C1.setText("X");
            }else{
                C1.setText("O");
            }
        }
        WindowC1 = true;
        win();
    }

    private void C2MousePressed(MouseEvent evt) {
        win();
        if(!WindowC2){
            if(Turn()){
                C2.setText("X");
            }else{
                C2.setText("O");
            }
        }
        WindowC2 = true;
        win();
    }

    private void C3MousePressed(MouseEvent evt) {
        win();
        if(!WindowC3){
            if(Turn()){
                C3.setText("X");
            }else{
                C3.setText("O");
            }
        }
        WindowC3 = true;
        win();
    }

    private void GameAgainMousePressed(MouseEvent evt) {

        //GameAgainMousePressed();
        A1.setText("");
        A2.setText("");
        A3.setText("");
        B1.setText("");
        B2.setText("");
        B3.setText("");
        C1.setText("");
        C2.setText("");
        C3.setText(""); // очищает клетки, после ничьей (по желанию сделаю для ничьей)

        // Label.setText("DRAW!"); */
        WindowA1 = false;
        WindowA2 = false;
        WindowA3 = false;
        WindowB1 = false;
        WindowB2 = false;
        WindowB3 = false;
        WindowC1 = false;
        WindowC2 = false;
        WindowC3 = false;

        Label.setText("");
    }



    private void A1MouseReleased(MouseEvent evt) {   } //событие,которое происходит после того как кнопку мыши отпустили

    private void A2MouseReleased(MouseEvent evt) { }

    private void B2MouseReleased(MouseEvent evt) { }

    private void B3MouseReleased(MouseEvent evt) { }

    private void C1MouseReleased(MouseEvent evt) {  }

    private void C2MouseReleased(MouseEvent evt) { }

    private void C3MouseReleased(MouseEvent evt) { }

    private void A1MouseClicked(MouseEvent evt) {    }

    private void formMouseMoved(MouseEvent evt) { }      // событие перемещения мыши

    private void formWindowActivated(WindowEvent evt) { } // событие при переходе из одно окна в другое

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Tic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Tic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tic.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tic g = new Tic();

                g.setBounds(0, 0, 316, 400);
                // g.setLocale(Locale.UK); меняет раскладку языка
                g.setResizable(false); // показыкает может ли пользователь менять размер окна
                g.setVisible(true); // поле видимое
                g.setLocationRelativeTo(null);
            }
        });
    }
}




