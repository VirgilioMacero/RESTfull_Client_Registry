/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restfull_client_registry;

import com.sun.jdi.connect.spi.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Virgilio
 */
public class ListUser {

    private List<User> Usuarios = new ArrayList<User>();

    public List<User> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<User> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public void loadUsers() throws IOException, ParseException {
        
        this.Usuarios.clear();
        String API = "http://127.0.0.1:3000/api/users";

        URL urlForGetReq = new URL(API);
        String read = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();
        connection.setRequestMethod("GET");

        int codeRes = connection.getResponseCode();

        if (codeRes == HttpURLConnection.HTTP_OK) {

            InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());

            BufferedReader br = new BufferedReader(isrObj);

            StringBuffer responseStr = new StringBuffer();

            while ((read = br.readLine()) != null) {

                responseStr.append(read);

            }

            br.close();

            connection.disconnect();

            JSONParser jsParser = new JSONParser();

            Object obj = jsParser.parse(responseStr.toString());;

            JSONArray Lista = new JSONArray();

            Lista = (JSONArray) obj;

            Lista.forEach(usr -> parseUserToObject((JSONObject) usr));


        } else {

            System.out.println("No se pudo conectar a la API");

        }

    }

    public void saveUser(User usuario) throws ProtocolException, MalformedURLException, IOException {

        String API = "http://127.0.0.1:3000/api/users?name=" + usuario.getName()
                + "&lastName=" + usuario.getLastName() + "&cedula=" + usuario.getCedula()
                + "&date=" + usuario.getFechaNacimiento() + "&directory=" + usuario.getDirectory()
                + "&phone=" + usuario.getPhone() + "&mail=" + usuario.getMail();

        URL urlForGetReq = new URL(API);
        HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();
        connection.setRequestMethod("POST");

        System.out.println(connection.getResponseMessage());

        connection.disconnect();

    }

    public void deleteUser(User usuario) throws IOException {

        String API = "http://127.0.0.1:3000/api/users/" + usuario.getId();

        URL urlForGetReq = new URL(API);
        String read = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();
        connection.setRequestMethod("DELETE");

        System.out.println("Se elimino el Usuario" + connection.getResponseMessage());

        connection.disconnect();

    }

    public void parseUserToObject(JSONObject obj) {

        long id = (long) obj.get("Id");
        String name = (String) obj.get("Name");
        String lastName = (String) obj.get("LastName");
        String Cedula = (String) obj.get("Cedula");
        String fecha = (String) obj.get("FechaNacimiento");
        String Directorio = (String) obj.get("PictureDirectory");
        String Tel = (String) obj.get("Phone");
        String Correo = (String) obj.get("Mail");

        User Temp = new User(id, name, lastName, Cedula, fecha, Directorio, Tel, Correo);

        Usuarios.add(Temp);

    }

}
