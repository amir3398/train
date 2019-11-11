package ir.amir3398.train.myClass;

import android.content.Context;
import android.content.SharedPreferences;

public class mySharedPrefrence {
    private static mySharedPrefrence instance;
    private SharedPreferences sp;

    private mySharedPrefrence(Context context){
        sp=context.getSharedPreferences("app",Context.MODE_PRIVATE);
    }

    public static mySharedPrefrence getInstance(Context context){

        if(instance==null)
            instance=new mySharedPrefrence(context);
        return instance;
    }

    public void setUsername(String username){
        sp.edit().putString("isUsername",username).apply();
    }

    public String getUsername(){
        return sp.getString("isUsername","");
    }

    public void clearSharedPrefrence(){
        sp.edit().clear().apply();
    }


    public void setPermission(){
        sp.edit().putBoolean("isPer",true).apply();
    }
    public boolean getPermission(){
        return sp.getBoolean("isPer",false);
    }


}
