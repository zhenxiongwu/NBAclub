package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Arena;
import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.table.model.Team;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class ControllerManager {

    public static final String PLAYERS_CONTROLLER = "players_controller";
    public static final String TEAMS_CONTROLLER = "team_controller";
    public static final String COACHES_CONTROLLER = "coach_controller";
    public static final String ARENAS_CONTROLLER = "arena_controller";
    public static final String PLAYER_DETAIL_CONTROLLER = "player_detail_controller";
    public static final String TEAM_DETAIL_CONTROLLER = "team_detail_controller";

    private static DataController playerController;
    private static DataController teamController;
    private static DataController coachController;
    private static DataController arenaController;

    private static DataController playerDetailController;
    private static DataController teamDetailController;


    private static String[] player_data_keys = new String[]{
            Player.NAME,
            Player.SEASON,
            Player.AGE,
            Player.TEAMABBER,
            Player.LEAGUE,
            Player.GAMES,
            Player.POINTS
    };

    private static int[] player_textview_ids = new int[]{
            R.id.player_list_item_textView_name,
            R.id.player_list_item_textView_season,
            R.id.player_list_item_textView_age,
            R.id.player_list_item_textView_teamAbbr,
            R.id.player_list_item_textView_league,
            R.id.player_list_item_textView_games,
            R.id.player_list_item_textView_points
    };

    private static String[] team_data_keys = new String[]{
            Team.NAME,
            Team.FROM_YEAR,
            Team.TO_YEAR,
            Team.YEARS,
            Team.LEAGEU,
            Team.WINS,
            Team.LOSES,
            Team.GAMES,
            Team.CHAMPIONSHIPS
    };

    private static int[] team_textview_ids = new int[]{
            R.id.team_list_item_textView_name,
            R.id.team_list_item_textview_from,
            R.id.team_list_item_textView_to,
            R.id.team_list_item_textView_years,
            R.id.team_list_item_textView_league,
            R.id.team_list_item_textView_win,
            R.id.team_list_item_textView_lose,
            R.id.team_list_item_textView_games,
            R.id.team_list_item_textView_champ
    };

    private static String[] arena_data_keys = new String[]{
            Arena.NAME,
            Arena.START_TO_END,
            Arena.TEAM,
            Arena.LOCATION,
            Arena.CAPACITY
    };

    private static int[] arena_textview_ids = new int[]{
            R.id.arena_list_item_textView_name,
            R.id.arena_list_item_textView_start2end,
            R.id.arena_list_item_textView_team,
            R.id.arena_list_item_textView_location,
            R.id.arena_list_item_textView_capacity
    };

    private static String[] player_detail_data_keys = new String[]{
            Player.SEASON,
            Player.TEAMABBER,
            Player.GAMES,
            Player.POINTS,
            Player.AVERAGE
    };

    private static int[] player_detail_textview_ids = new int[]{
            R.id.playerDetail_textView_season,
            R.id.playerDetail_textView_team,
            R.id.playerDetail_textView_games,
            R.id.playerDetail_textView_points,
            R.id.playerDetail_textView_average
    };


    public static DataController getController(String entityClass) {
        switch (entityClass) {
            case PLAYERS_CONTROLLER:
                if (playerController == null)
                    playerController = new PlayerController(R.layout.player_list_item,
                            player_data_keys,player_textview_ids);
                return playerController;
            case TEAMS_CONTROLLER:
                if (teamController == null)
                    teamController = new TeamController(R.layout.team_list_item,
                            team_data_keys,team_textview_ids);
                return teamController;
            case COACHES_CONTROLLER:
//                if (coachController == null)
//                    coachController = new CoachController();
                return coachController;
            case ARENAS_CONTROLLER:
                if (arenaController == null)
                    arenaController = new ArenaController(R.layout.arena_list_item,
                            arena_data_keys, arena_textview_ids);
                return arenaController;
            case PLAYER_DETAIL_CONTROLLER:
                if(playerDetailController == null)
                    playerDetailController = new DataController(R.layout.playerdetail_list_item,
                            player_detail_data_keys,player_detail_textview_ids) {
                        @Override
                        public void onItemClick(Context context, EntityModel entityModel, int position) {

                        }
                    };
                return playerDetailController;
            case TEAM_DETAIL_CONTROLLER:
                if(teamDetailController == null)
                    teamDetailController = new TeamDetailController(0,null,null);
                return teamDetailController;
            default:
                return null;
        }
    }
}
