package Lab11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteMap {
    private boolean[][] MAP;

    private String PATH="/Users/alekseyzhizhin/IdeaProjects/";
    public WriteMap(boolean[][] MAP) {
        this.MAP = MAP;
    }


    public void writeMap() throws IOException {
        InitSettings settings = new InitSettings(MAP.length, MAP[0].length);
        String nameOfFile = settings.getWIDTH() + "_" + settings.getHEIGHT();
        Writer writerOnTxt = new FileWriter(PATH + nameOfFile);
        writerOnTxt.write("map_size " + settings.getWIDTH() + " " + settings.getHEIGHT() + "\n");

        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[0].length; j++) {
                if (MAP[i][j]) {
                    writerOnTxt.write("1\t");
                } else {
                    writerOnTxt.write("0\t");
                }
            }
            writerOnTxt.write("\n");
        }
        writerOnTxt.flush();
        writerOnTxt.close();
    }
}