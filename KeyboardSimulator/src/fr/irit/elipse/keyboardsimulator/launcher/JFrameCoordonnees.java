package fr.irit.elipse.keyboardsimulator.launcher;

import javax.swing.JFrame;
import javax.swing.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class JFrameCoordonnees {
	
	public static void main(String[] args) {
        // Chemin du fichier XML
        String filePath = "logs/test-keyboard.xml";

        // Récupèrer les entrées du fichier XML
        NodeList entries = XmlReader.readXml(filePath);

        // init de la JFrame
        JFrame frame = new JFrame("Coordonnées"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocation(1200, 150);

        // Créer une JList pour afficher les coordonnées
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Parcourir chaque entrée dans la liste entries
        for (int i = 0; i < entries.getLength(); i++) {
            // Obtenir l'élément entry actuel
            Element entry = (Element) entries.item(i);
            
            /**
             * VERIFICATION DU TYPE FACULTATIF
             */
            // Récupérer la valeur de l'attribut "type"
            String type = entry.getAttribute("type");

            // Vérifier si le type est "eyePosition"
            if ("eyePosition".equals(type)) {
                // Récupérer le texte à l'intérieur de l'élément entry (les coordonnées)
                String coordinates = entry.getTextContent().trim();

                // Ajouter les coordonnées à la liste pour affichage (Typage facultatif aussi)
                listModel.addElement("Type: " + type + ", Coordonnées: " + coordinates);
            }
        }

        // Créer une JList avec le modèle de liste créé
        JList<String> coordinateList = new JList<>(listModel);

        // Créer un JScrollPane pour permettre le défilement si la liste est trop grande
        JScrollPane scrollPane = new JScrollPane(coordinateList);

        // Ajouter le JScrollPane à la JFrame
        frame.getContentPane().add(scrollPane);

        // Afficher la JFrame
        frame.setVisible(true);
    }
}
