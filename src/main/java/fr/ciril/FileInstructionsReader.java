package fr.ciril;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileInstructionsReader {

    Player readInstructionsFromFile(String path) {
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
            int x = Integer.parseInt(lines.get(0).substring(0, 1));
            int y = Integer.parseInt(lines.get(0).substring(2, 3));
            String instructions = lines.get(1);
            return new Player(x, y, instructions);

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
