package SlurmSubmitJob;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface LibC extends LibCAPI, Library {
    String NAME = "c";
    LibC INSTANCE = Native.loadLibrary(NAME, LibC.class);
    
    void printf(String format, Object... args);

}

