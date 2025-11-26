package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {

        // Check if list is null or empty & if so reject 
        if(bpms == null || bpms.isEmpty()){
            throw new IllegalArgumentException("The bpms list cannot be null or empty"); 
        }

        // calculate the total bpms from the list 
        int averageBPM = 0; 
        for(int value : bpms){
            averageBPM += value; 
        }

        // takes the total bpms divided by amount provided to get average 
        averageBPM = averageBPM / bpms.size(); 

        // Return "HIGH" if avg BPM ≥ 140
        if(averageBPM >= 140){
            return new String("HIGH");
        }

        // Return "MEDIUM" if 100–139
        else if(averageBPM <= 139 && averageBPM >= 100){
            return new String("MEDIUM"); 
        }

        // Return "LOW" if < 100
        return new String("LOW"); 
    }


    public static boolean isValidTrackTitle(String title) {
        // confirm that title is not null and has a valid length 
        if(title == null || title.length() ==0 || title.length() > 30){
            return false; 
        }

        // confirm that every character is a letter or a space
        for(char c : title.toCharArray()){
            if(!Character.isLetter(c) && c != ' '){
                return false; 
            }
        }

        return true; 
    }

    // clamp volume into range 0-100 (e.g., 120 -> 100, -10 -> 0)
    public static int normalizeVolume(int volumeDb) {
        int normalVolumeLevel = volumeDb; 

        //when volume is too low, bring up to 0
        if(volumeDb < 0){
            normalVolumeLevel = 0; 
        }

        //when volume is too high, bring down to 100
        else if(volumeDb > 100){
            normalVolumeLevel = 100; 
        }

        //provide the normalized volume level or the original value if already valid normal level 
        return normalVolumeLevel; 
    }
}
