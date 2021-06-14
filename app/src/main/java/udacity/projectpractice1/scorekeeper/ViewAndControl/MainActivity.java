package udacity.projectpractice1.scorekeeper.ViewAndControl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import udacity.projectpractice1.scorekeeper.Models.ScoreModel;
import udacity.projectpractice1.scorekeeper.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Create model object for both teams.
    private ScoreModel teamAModel;
    private ScoreModel teamBModel;

    // Create object of Button class.
    private Button teamAShortShootButton;
    private Button teamALongShootButton;
    private Button teamAFoulsButton;
    private Button teamBShortShootButton;
    private Button teamBLongShootButton;
    private Button teamBFoulsButton;
    private Button resetButton;

    // Create object of TextView class;
    private TextView teamAScoreTextView;
    private TextView teamAFoulsTextView;
    private TextView teamBScoreTextView;
    private TextView teamBFoulsTextView;

    /**
     * Initialize the Activity.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the data models.
        teamAModel = new ScoreModel();
        teamBModel = new ScoreModel();

        // Assign button IDs to the object.
        teamAShortShootButton = findViewById(R.id.team_a_short_shoot_button);
        teamALongShootButton = findViewById(R.id.team_a_long_shoot_button);
        teamAFoulsButton = findViewById(R.id.team_a_fouls_button);
        teamBShortShootButton = findViewById(R.id.team_b_short_shoot_button);
        teamBLongShootButton = findViewById(R.id.team_b_long_shoot_button);
        teamBFoulsButton = findViewById(R.id.team_b_fouls_button);
        resetButton = findViewById(R.id.reset_button);

        // Assign TextView IDs to the object.
        teamAScoreTextView = findViewById(R.id.team_a_score_text_view);
        teamAFoulsTextView = findViewById(R.id.team_a_fouls_text_view);
        teamBScoreTextView = findViewById(R.id.team_b_score_text_view);
        teamBFoulsTextView = findViewById(R.id.team_b_fouls_text_view);

        // setup the click listener for each button.
        teamAShortShootButton.setOnClickListener(this);
        teamALongShootButton.setOnClickListener(this);
        teamAFoulsButton.setOnClickListener(this);
        teamBShortShootButton.setOnClickListener(this);
        teamBLongShootButton.setOnClickListener(this);
        teamBFoulsButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    /**
     * This function listens which button is clicked and make performance.
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.team_a_long_shoot_button:
                teamAModel.longShootUpdate();
                teamAScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamAModel.getTeamScore()));
                break;
            case R.id.team_a_short_shoot_button:
                teamAModel.shortShootUpdate();
                teamAScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamAModel.getTeamScore()));
                break;
            case R.id.team_a_fouls_button:
                teamAModel.foulsUpdate();
                if (teamAModel.getTeamFouls() >= 2) {
                    teamBModel.socreUpdateFromOpponentFouls();
                    teamBScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamScore()));
                    teamAModel.setTeamFouls(0);
                }
                teamAFoulsTextView.setText(String.format(Locale.ENGLISH,"%d", teamAModel.getTeamFouls()));
                break;
            case R.id.team_b_long_shoot_button:
                teamBModel.longShootUpdate();
                teamBScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamScore()));
                break;
            case R.id.team_b_short_shoot_button:
                teamBModel.shortShootUpdate();
                teamBScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamScore()));
                break;
            case R.id.team_b_fouls_button:
                teamBModel.foulsUpdate();
                if (teamBModel.getTeamFouls() >= 2) {
                    teamAModel.socreUpdateFromOpponentFouls();
                    teamAScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamAModel.getTeamScore()));
                    teamBModel.setTeamFouls(0);
                }
                teamBFoulsTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamFouls()));
                break;
            case R.id.reset_button:
                teamAModel.resetTeamScoreAndFouls();
                teamBModel.resetTeamScoreAndFouls();
                teamAScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamAModel.getTeamScore()));
                teamAFoulsTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamFouls()));
                teamBScoreTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamScore()));
                teamBFoulsTextView.setText(String.format(Locale.ENGLISH,"%d", teamBModel.getTeamFouls()));
                break;
        }
    }
}