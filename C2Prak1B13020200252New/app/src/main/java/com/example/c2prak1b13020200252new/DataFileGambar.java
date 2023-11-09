package com.example.c2prak1b13020200252new;

import java.io.File;

public class DataFileGambar {
    private String pathFile;
    private File file;


    public  DataFileGambar(String pathFile, File file) {
        this.file = file;
        this.pathFile = pathFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
