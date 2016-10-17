package com.mishkurov;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Anton_Mishkurov
 */
public class FileEventLogger implements EventLogger {
    private File file;

    public FileEventLogger(String filename) {
        this.file = new File(filename);
    }

    @Override
    public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(file, msg.toString()+"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        if (!file.canWrite()) {
            throw new IllegalStateException("Cannot write to file!" + file.toString());
        }
    }
}
