package com.example.asus1.nbatest.controller;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class ControllerManager {

    public static final String PLAYER_CONTROLLER = "player_controller";
    public static final String TEAM_CONTROLLER = "team_controller";
    public static final String COACH_CONTROLLER = "coach_controller";
    public static final String ARENA_CONTROLLER = "arena_controller";

    private static DataController playerController;
    private static DataController teamController;
    private static DataController coachController;
    private static DataController arenaController;

    static DataController getController(String entityClass) {
        switch (entityClass) {
            case PLAYER_CONTROLLER:
                if (playerController == null)
                    playerController = new PlayerController();
                return playerController;
            case TEAM_CONTROLLER:
                if (teamController == null)
                    teamController = new TeamController();
                return teamController;
            case COACH_CONTROLLER:
                if (coachController == null)
                    coachController = new CoachController();
                return coachController;
            case ARENA_CONTROLLER:
                if (arenaController == null)
                    arenaController = new ArenaController();
                return arenaController;
            default:
                return null;
        }
    }
}
