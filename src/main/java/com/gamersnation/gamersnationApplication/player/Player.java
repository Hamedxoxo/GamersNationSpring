package com.gamersnation.gamersnationApplication.player;

import javax.persistence.*;
import java.util.Locale;

@Entity
public class Player{
    @Id //definer puuid som primary key i tabellen
    private String puuid;
    private String summonerName;
    private boolean rankMode;
    private int level;
    private String rank;
    private double tolerance;
    private double commitment;
    private boolean voiceChat;
    private String position;

    @Transient //matchPercent skal ikke være en attributte i player tabellen
    private double matchPercent;


    //Constructor with no parameter
    public Player(){}

    //Constructor without puuid and summonerName
    public Player(boolean rankMode, int level, String rank, double tolerance, double commitment, boolean voiceChat, String position) {
        this.rankMode = rankMode;
        this.level = level;
        this.rank = rank;
        this.tolerance = tolerance;
        this.commitment = commitment;
        this.voiceChat = voiceChat;
        this.position = position;
    }

    //Constructor with all parameters
    public Player(String puuid, String summonerName, int level, String rank, boolean rankMode, double tolerance, double commitment, boolean voiceChat, String position){
        this.puuid = puuid;
        this.summonerName = summonerName;
        this.rankMode = rankMode;
        this.level = level;
        this.rank=rank;
        this.tolerance=tolerance;
        this.commitment=commitment;
        this.voiceChat=voiceChat;
        this.position=position;
        this.matchPercent=matchPercent;
    }

    //Getters og setters
    public String getPuuid() {return puuid;}

    public String getSummonerName(){
        return summonerName;
    }

    public boolean getRankMode(){
        return rankMode;
    }

    public int getLevel(){
        return level;
    }

    public String getRank(){
        return rank;
    }

    public double getTolerance(){
        return tolerance;
    }

    public double getCommitment(){
        return commitment;
    }

    public boolean getVoiceChat(){
        return voiceChat;
    }

    public String getPosition(){
        return position;
    }

    public double getMatchPercent() {
        return matchPercent;
    }

    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    //Modificerer rank fra string til en numerisk værdi
    public double rankToNumberModifyer(){
        if (rank.toLowerCase(Locale.ROOT).contains("unranked") || rank == null){
            return 1;
        }else if (rank.toLowerCase(Locale.ROOT).contains("iron")){
            return 11;
        }else if (rank.toLowerCase(Locale.ROOT).contains("bronze")){
            return 21;
        }else if (rank.toLowerCase(Locale.ROOT).contains("silver")){
            return 31;
        }else if (rank.toLowerCase(Locale.ROOT).contains("gold")){
            return 41;
        }else if (rank.toLowerCase(Locale.ROOT).contains("platinum")){
            return 51;
        }else if (rank.toLowerCase(Locale.ROOT).contains("diamond")){
            return 61;
        }else if (rank.toLowerCase(Locale.ROOT).contains("master") &&
                !rank.toLowerCase(Locale.ROOT).contains("grandmaster")){
            return 71;
        }else if (rank.toLowerCase(Locale.ROOT).contains("grandmaster")){
            return 81;
        }else if (rank.toLowerCase(Locale.ROOT).contains("challenger")){
            return 91;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Player{" +
                "puuid='" + puuid + '\'' +
                ", name='" + summonerName + '\'' +
                ", rank mode=" + rankMode +
                ", level=" + level +
                ", rank=" + rank +
                ", tolerance=" + tolerance +
                ", commitment=" + commitment +
                ", voiceChat=" + voiceChat +
                ", position=" + position +
                ",matchPercent=" + matchPercent+
                '}';
    }
}