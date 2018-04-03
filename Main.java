

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Button> buttons = new ArrayList<Button>();
    Button button[][] = new Button[3][3];
    private int roundCount=1;



    int winningCombinations[][]  = new int[][] { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {6,4,2} };


    Boolean xTurn = true;

    TextView textView;
    String x = "X";
    String o = "O";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button gameAgain = (Button)findViewById(R.id.gameAgain);
        buttons.add((Button)findViewById(R.id.A1));
        buttons.add((Button)findViewById(R.id.A2));
        buttons.add((Button)findViewById(R.id.A3));
        buttons.add((Button)findViewById(R.id.B1));
        buttons.add((Button)findViewById(R.id.B2));
        buttons.add((Button)findViewById(R.id.B3));
        buttons.add((Button)findViewById(R.id.C1));
        buttons.add((Button)findViewById(R.id.C2));
        buttons.add((Button)findViewById(R.id.C3));



        textView = (TextView)findViewById(R.id.textView);



        gameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Iterator<Button> j = buttons.iterator();
                     j.hasNext();) {
                    final Button Btn = j.next();

                    Btn.setText("");
                    Btn.setClickable(true);

                    textView.setText("");
                    roundCount = 1;
                }
            }
        });




        for (Iterator<Button> i = buttons.iterator(); i.hasNext();) {
            final Button btn = i.next();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (xTurn) {
                        btn.setText("X");
                        btn.setClickable(false);

                        gameFinished();

                        xTurn = false;
                        roundCount++;
                    } else {


                        btn.setText("O");
                        btn.setClickable(false);


                        gameFinished();

                        xTurn = true;
                        roundCount++;
                    }
                }

            });
        }
    }






    public boolean gameFinished() {
        for (int i = 0; i < winningCombinations.length; i++) {
            if (buttons.get(winningCombinations[i][0]).getText() == buttons.get(winningCombinations[i][1]).getText() &&
                    buttons.get(winningCombinations[i][1]).getText() == buttons.get(winningCombinations[i][2]).getText())
                if (buttons.get(winningCombinations[i][0]).getText().equals("X") || buttons.get(winningCombinations[i][0]).getText().equals("O")) {
                    if (buttons.get(winningCombinations[i][1]).getText().equals("X") || buttons.get(winningCombinations[i][1]).getText().equals("O")) {
                        if (buttons.get(winningCombinations[i][2]).getText().equals("X") || buttons.get(winningCombinations[i][2]).getText().equals("O")) {

                            if (xTurn) {
                                textView.setText("Winner X");
                                for (Iterator<Button> j = buttons.iterator();
                                     j.hasNext();) {
                                    final Button Btn = j.next();

                                    Btn.setClickable(false); }

                                //

                            } else {
                                textView.setText("Winner O");
                                for (Iterator<Button> j = buttons.iterator();
                                     j.hasNext();) {
                                    final Button Btn = j.next();

                                    Btn.setClickable(false); }
                            }

                        }}}
        } if (roundCount==9) {
            textView.setText("Draw");
        }
        return false;
    } }


