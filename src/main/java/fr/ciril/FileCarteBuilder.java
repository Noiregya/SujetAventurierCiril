package fr.ciril;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileCarteBuilder {

    Carte readCarteFromFile(String path) {
        URL url = this.getClass().getClassLoader().getResource(path);
        InputStream inputStream = null;
        try {
            if (url == null) {
                throw new FileNotFoundException(path);
            }
            File file = new File(url.getFile());
            //Lire le fichier d'entrée
            inputStream = new FileInputStream(file);
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().toList();

            //Créer l'objet carte
            char[][] carteMatrix = new char[lines.size()][lines.get(0).length()];
            for (int i = 0; i < lines.size(); i++) {
                carteMatrix[i] = lines.get(i).toCharArray();
            }
            return new Carte(carteMatrix);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //Essayer de fermer le stream
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
