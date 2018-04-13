package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents an upload instance with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Upload implements Serializable{
    /**
     * content byte array and corresponding file name are fields of data about the upload instance.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private byte[] content;
    private String command;
    private String fileName;
    private String fileExtension;

    /**
     * A method to allow the user to upload a file as a byte array
     */
    public Upload(byte[] content, String fileName, String fileExtension) {
        this.content = content;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public byte[] getContent() {
        return this.content;
    }
    public String getCommand() {
        return this.command;
    }
    public String getFileName() { return this.fileName;}
    public String getFileExtension() {
        return this.fileExtension;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
}
