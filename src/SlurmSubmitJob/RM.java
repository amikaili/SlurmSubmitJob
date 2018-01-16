package SlurmSubmitJob;

import com.sun.jna.Library;
import com.sun.jna.Native;

// Deprecated:
public interface RM extends LibCAPI, Library {
    String NAME = "CoreServices";
    RM INSTANCE = (RM) Native.loadLibrary(NAME, RM.class);
    void printf(String format, Object... args);
}
