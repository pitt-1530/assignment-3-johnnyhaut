package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public static void placeholder() {

        // ---------------- CLASSIFY ENERGY TESTS ----------------------------
        // classifyTest1: null list, should throw an exception
        List<Integer> test1 = null;
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(test1));

        // classifyTest2: empty list, should throw an exception
        List<Integer> test2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(test2));

        // classifyTest3: high bpm 140, should return 'HIGH'
        List<Integer> test3 = new ArrayList<>();
        test3.add(140);
        test3.add(140);
        test3.add(140);
        test3.add(140);
        String output3 = PlaylistRecommender.classifyEnergy(test3);
        assertEquals("HIGH", output3);

        // classifyTest4: medium bpm 120, should return 'MEDIUM'
        List<Integer> test4 = new ArrayList<>();
        test4.add(120);
        test4.add(120);
        test4.add(120);
        String output4 = PlaylistRecommender.classifyEnergy(test4);
        assertEquals("MEDIUM", output4);

        // classifyTest5: low bpm 99, should return 'LOW'
        List<Integer> test5 = new ArrayList<>();
        test5.add(99);
        test5.add(99);
        String output5 = PlaylistRecommender.classifyEnergy(test5);
        assertEquals("LOW", output5);
        // -------------------------------------------------------------------

        // ---------------- VALID TRACK TESTS ----------------------------
        // isValidTrackTest6: empty track title, should return false
        String title6 = "";
        boolean output6 = PlaylistRecommender.isValidTrackTitle(title6);
        assertFalse(output6);

        // isValidTrackTest7: title that's too long, should return false
        String title7 = "aaabbbcccdddeeefffggghhhiiijjjkkklllmmmnnnooopppqqqrrrssstttuuuvvvwwwxxxyyyzzz";
        boolean output7 = PlaylistRecommender.isValidTrackTitle(title7);
        assertFalse(output7);

        // isValidTrackTest8: title with invalid character, should return false
        String title8 = "testing!";
        boolean output8 = PlaylistRecommender.isValidTrackTitle(title8);
        assertFalse(output8);

        // isValidTrackTest9: valid title, should return true
        String title9 = "Lifes a Trip";
        boolean output9 = PlaylistRecommender.isValidTrackTitle(title9);
        assertTrue(output9);

        // -------------------------------------------------------------------

        // ---------------- NORMALIZE VOLUME TESTS ----------------------------
        // normalVolumeTest10: volume too high (1234), should return 100
        int output10 = PlaylistRecommender.normalizeVolume(1234); 
        assertEquals(100, output10); 

        // normalVolumeTest11: volume too low (-20), should return 0
        int output11 = PlaylistRecommender.normalizeVolume(-20); 
        assertEquals(0, output11);

        // normalVolumeTest12: valid volume (14), should return 14
        int output12 = PlaylistRecommender.normalizeVolume(14); 
        assertEquals(14, output12); 
        // -------------------------------------------------------------------

    }
}
