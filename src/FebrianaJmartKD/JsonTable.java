package FebrianaJmartKD;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable <T> extends Vector {

    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T>clazz, String filepath) throws IOException{
        this.filepath = filepath;
    }

    public static<T> JsonReader readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
        T clazzT = null;
        try{
            final JsonReader reader = new JsonReader(new FileReader(filepath));
            clazzT = gson.fromJson(reader, clazz.getClass());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return(JsonReader) clazzT;
    }

    public void writeJson() throws IOException{
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException{
        try{
            FileWriter writer = new  FileWriter(filepath);
            String json = gson.toJson(object);
            writer.write(gson.toJson(object));
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
