package com.example.neel.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List <Integer> Player1;
    List <Integer> Player2;
    int active_player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Player1 = new ArrayList<Integer>();
        Player2 = new ArrayList<Integer>();
        active_player = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        Button buttonSelected = (Button) view;
        String resource_name = view.getResources().getResourceEntryName(buttonSelected.getId());
        playGame(buttonSelected, resource_name);
    }

    public void playGame(Button buttonSelected, String button_name){
        if (active_player == 1) {
            Player1.add(Integer.parseInt(""+button_name.charAt(button_name.length() - 1)));
            buttonSelected.setBackgroundColor(Color.GREEN);
            buttonSelected.setText("X");
            if (check_win(active_player)) {
                System.out.println("WON");
                Toast.makeText(this, String.format("The winner is Player %d", active_player),
                        Toast.LENGTH_LONG).show();
            }
            active_player = 2;
        } else {
            Player2.add(Integer.parseInt("" + button_name.charAt(button_name.length() - 1)));
            buttonSelected.setBackgroundColor(Color.BLUE);
            buttonSelected.setText("X");
            if (check_win(active_player)) {
                System.out.println("WON");
                Toast.makeText(this, String.format("The winner is Player %d", active_player),
                        Toast.LENGTH_LONG).show();
            }
            active_player = 1;
        }

    }
    public boolean check_win(int active_player) {
        ArrayList<List<Integer>> winningCombos = new ArrayList<>();
        winningCombos.add(Arrays.asList(1,2,3));
        winningCombos.add(Arrays.asList(4,5,6));
        winningCombos.add(Arrays.asList(7,8,9));
        winningCombos.add(Arrays.asList(1,4,7));
        winningCombos.add(Arrays.asList(2,5,8));
        winningCombos.add(Arrays.asList(3,6,9));
        winningCombos.add(Arrays.asList(1,5,9));
        winningCombos.add(Arrays.asList(3,5,7));

        if (active_player == 1) {
            System.out.println(Player1);
            for (List<Integer> combos: winningCombos) {
                System.out.println(combos);
                if (Player1.containsAll(combos)) {
                    return true;
                }
            }
        }
        if (active_player == 2) {
            for (List<Integer> combos: winningCombos) {
                if (Player2.containsAll(combos)) {
                    return true;
                }
            }
        }
        return false;
    };
}
