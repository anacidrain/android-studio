import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Button> buttons = new ArrayList<Button>();
    Button button[][] = new Button[3][3];
    private int roundCount = 1;


    int winningCombinations[][] = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {6, 4, 2}};

    TextView textView;
    String x = "X";
    String o = "O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button [0][0] = (Button)findViewById(R.id.A1);
        button [0][1] = (Button)findViewById(R.id.A2);
        button [0][2] = (Button)findViewById(R.id.A3);
        button [1][0] = (Button)findViewById(R.id.B1);
        button [1][1] = (Button)findViewById(R.id.B2);
        button [1][2] = (Button)findViewById(R.id.B3);
        button [2][0] = (Button)findViewById(R.id.C1);
        button [2][1] = (Button)findViewById(R.id.C2);
        button [2][2] = (Button)findViewById(R.id.C3);

        Button gameAgain = (Button) findViewById(R.id.gameAgain);
        buttons.add((Button) findViewById(R.id.A1));
        buttons.add((Button) findViewById(R.id.A2));
        buttons.add((Button) findViewById(R.id.A3));
        buttons.add((Button) findViewById(R.id.B1));
        buttons.add((Button) findViewById(R.id.B2));
        buttons.add((Button) findViewById(R.id.B3));
        buttons.add((Button) findViewById(R.id.C1));
        buttons.add((Button) findViewById(R.id.C2));
        buttons.add((Button) findViewById(R.id.C3));


        textView = (TextView) findViewById(R.id.textView);


        gameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Iterator<Button> j = buttons.iterator();
                     j.hasNext(); ) {
                    final Button Btn = j.next();

                    Btn.setText("");
                    Btn.setClickable(true);

                    textView.setText("");
                    roundCount = 1;
                }
            }
        });


        for (Iterator<Button> i = buttons.iterator(); i.hasNext(); ) {
            final Button btn = i.next();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    btn.setText("X");
                    btn.setClickable(false);

                    if ( ! gameFinishedX() ) {
                        intellectComputer();
                    }

                    roundCount++;
                }
            });
        }
    }

    private void intellectComputer() {

        Random random = new Random();

        List <Button> freeButton = new ArrayList<Button>() ;

        for (int i=0; i < 3 ; i++) {
            for (int j=0; j<3; j++) {
                if (button[i][j].getText().equals("")) {
                    freeButton.add(button[i][j]) ;
                }
            }
        }
        Button btn = freeButton.get(random.nextInt(freeButton.size()-1));


        if (button[1][1].getText() == x && button[0][0].getText() == "" ) {
            button[0][0].setText(o);
            button[0][0].setClickable(false);

        }
        else if (button[0][0].getText() == x && button[2][2].getText() == "" ) {
            button[2][2].setText(o);
            button[2][2].setClickable(false);
        }

        else if (button[0][2].getText()==x && button[2][0].getText() == "") {
            button[2][0].setText(o);
            button[2][0].setClickable(false);
        }

        else if (button[2][0].getText()==x && button[0][2].getText() == "" ) {
            button[0][2].setText(o);
            button[0][2].setClickable(false);
        }

        else  if (button[2][2].getText()==x && button[0][0].getText() == "" ) {
            button[0][0].setText(o);
            button[0][0].setClickable(false);
        }

        else if (button[0][1].getText() == x && button[2][1].getText() == "" && button[0][0].getText() != x && button[0][2].getText() != x) {
            button[2][1].setText(o);
            button[2][1].setClickable(false);
        }

        else if (button[2][1].getText() ==x && button[0][1].getText() == "" && button[2][0].getText() != x && button[2][2].getText() != x) {
            button[0][1].setText(o);
            button[0][1].setClickable(false);
        }
        else if (button[1][0].getText() == x && button[1][2].getText() == "" && button[0][0].getText() != x && button[2][0].getText() != x) {
            button[1][2].setText(o);
            button[1][2].setClickable(false);
        }
        else if (button[1][2].getText() == x && button[1][0].getText() == "" && button[2][0].getText() != x && button[2][2].getText() != x) {
            button[1][0].setText(o);
            button[1][0].setClickable(false);
        }


        else if (button[0][0].getText() == x && button[0][1].getText() == x && button[0][2].getText() == "" ) {
            button[0][2].setText(o);
            button[0][2].setClickable(false);

        }
        else if (button[0][2].getText() == x && button[0][1].getText() == x && button[0][0].getText() == "") {
            button[0][0].setText(o);
            button[0][0].setClickable(false);

        }

        else if (button[0][0].getText() == x && button[1][0].getText()==x && button[2][0].getText() == "") {
            button[2][0].setText(o);
            button[2][0].setClickable(false);
        }
        else if (button[2][0].getText()== x && button[1][0].getText() == x && button[0][0].getText() == "") {
            button[0][0].setText(o);
            button[0][0].setClickable(false);
        }
        else if (button[2][0].getText() == x && button[2][1].getText() == x && button[2][2].getText()== "") {
            button[2][2].setText(o);
            button[2][2].setClickable(false);
        }
        else if (button[2][2].getText() ==x && button[2][1].getText() ==x && button[2][0].getText() == "") {
            button[2][0].setText(o);
            button[2][0].setClickable(false);
        }
        else if (button[0][2].getText() ==x && button [1][2].getText() ==x && button[2][2].getText() == "") {
            button[2][2].setText(o);
            button[2][2].setClickable(false);
        }
        else if (button[2][2].getText() ==x && button [1][2].getText() ==x && button[0][2].getText() == "") {
            button[0][2].setText(o);
            button[0][2].setClickable(false);
        }
        else { btn.setText(o);
            btn.setClickable(false);
        }

        gameFinishedO();
    }


    public boolean gameFinishedX() {



        for (int i = 0; i < winningCombinations.length; i++) {
            if (buttons.get(winningCombinations[i][0]).getText() == buttons.get(winningCombinations[i][1]).getText() &&
                    buttons.get(winningCombinations[i][1]).getText() == buttons.get(winningCombinations[i][2]).getText())
                if (buttons.get(winningCombinations[i][0]).getText().equals(x)) {
                    if (buttons.get(winningCombinations[i][1]).getText().equals(x)) {
                        if (buttons.get(winningCombinations[i][2]).getText().equals(x)) {


                            textView.setText("Winner X");
                            for (Iterator<Button> j = buttons.iterator();
                                 j.hasNext(); ) {
                                final Button Btn = j.next();

                                Btn.setClickable(false);

                            }
                            return true;
                        }
                    }
                }
        }
        if (roundCount == 5) {
            textView.setText("Draw");
            return true;

        }
        return false;
    }


    public boolean gameFinishedO() {



        for (int i = 0; i < winningCombinations.length; i++) {
            if (buttons.get(winningCombinations[i][0]).getText() == buttons.get(winningCombinations[i][1]).getText() &&
                    buttons.get(winningCombinations[i][1]).getText() == buttons.get(winningCombinations[i][2]).getText())
                if (buttons.get(winningCombinations[i][0]).getText().equals(o)) {
                    if (buttons.get(winningCombinations[i][1]).getText().equals(o)) {
                        if (buttons.get(winningCombinations[i][2]).getText().equals(o)) {


                            textView.setText("Winner O");
                            for (Iterator<Button> j = buttons.iterator();
                                 j.hasNext(); ) {
                                final Button Btn = j.next();

                                Btn.setClickable(false);
                            }
                            return true;
                        }
                    }
                }
        }
        if (roundCount == 5) {
            textView.setText("Draw");
            return true;
        }
        return false;
    }

}