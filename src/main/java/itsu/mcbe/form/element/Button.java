package itsu.mcbe.form.element;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import cn.nukkit.utils.MainLogger;

public class Button {

    private String type = "button";
    private String text;
    private Map<String, Object> image = new HashMap<>();

    public Button() {
        this("");
    }

    public Button(String text) {
        this.text = text;
        image.put("data", "");
        image.put("type", "");
    }

    public Button(String text, String imageType, String imageData) {
        this.text = text;

        if (imageType.equals("path")) {
            if(!image.containsKey("type")) this.image.put("type", "path");
            if(!image.containsKey("data")) this.image.put("data", this.getImageByteArray(new File(imageData)));

        } else if(imageType.equals("url")){
            if(!image.containsKey("type")) this.image.put("type", "url");
            if(!image.containsKey("data")) this.image.put("data", imageData);

        } else {
            throw new IllegalArgumentException("Not allowed image type: " + imageType + "\nYou have to specity url or path as image type.");
        }

    }

    public Button setImage(String imageType, String imageData){

        if (imageType.equals("path")) {
            this.image.put("type", "path");
            this.image.put("data", this.getImageByteArray(new File(imageData)));

        } else if(imageType.equals("url")){
            this.image.put("type", "url");
            this.image.put("data", imageData);

        } else {
            throw new IllegalArgumentException("Not allowed image type: " + imageType + "\nYou have to specity url or path as image type.");
        }
        
        return this;
    }

    public byte[] getImageByteArray(File file) {
        try {
            BufferedImage image = ImageIO.read(file);

            if (image.getHeight() != 128 || image.getWidth() != 128) {
                image = new BufferedImage(128, 128, image.getType());
                Graphics2D g = image.createGraphics();
                g.drawImage(image, 0, 0, 128, 128, null);
                g.dispose();
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, file.getName().substring(file.getName().lastIndexOf(".") + 1), baos);

            return baos.toByteArray();
        } catch (IOException e) {
            MainLogger.getLogger().logException(e);
        }

        return null;
    }

    public Button setText(String text){
        this.text = text;
        return this;
    }

    public String getText(){
        return this.text;
    }

    public String getName() {
        return "Button";
    }
    
    public Map<String, Object> getImage() {
    	return image;
    }

    public void onClick() {
    	
    }

}