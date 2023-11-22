package graphicEngine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageManager {

	private static ImageManager instance;
	private Map<Integer,BufferedImage> elementMap;
	private Map<Integer,BufferedImage> familleMap;

	public static ImageManager getInstance() {
		if (instance == null) {
			instance = new ImageManager();
		}
		return instance;
	}

	private ImageManager() {
		elementMap = new HashMap<Integer, BufferedImage>();
		familleMap = new HashMap<Integer, BufferedImage>();
		
		LoadElementImages();
		LoadFamilleImages();
	}

	private void LoadElementImages() {
		try {
			String path = new File(".").getCanonicalPath();
			File directoryPath = new File(path+"/src/main/resources/element");
			String contents[] = directoryPath.list();
			
			for(int i=0; i<contents.length; i++) {
				String fileName = contents[i];
				BufferedImage elemImg = ImageIO.read(getClass().getResourceAsStream("/element/" + fileName));
				
				String idString = fileName.replace("element_","").replace(".png","");
				System.out.println(idString);
				try {
					int id = Integer.parseInt(idString);
					elementMap.put(id, elemImg);
				}catch(NumberFormatException e) {
					System.out.println("Mauvais nom element skip file : " + fileName);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void LoadFamilleImages() {
		try {
			String path = new File(".").getCanonicalPath();
			File directoryPath = new File(path+"/src/main/resources/famille");
			String contents[] = directoryPath.list();
			
			for(int i=0; i<contents.length; i++) {
				String fileName = contents[i];
				BufferedImage elemImg = ImageIO.read(getClass().getResourceAsStream("/famille/" + fileName));
				
				String idString = fileName.replace("famille_","").replace(".png","");
				//System.out.println(idString);
				try {
					int id = Integer.parseInt(idString);
					familleMap.put(id, elemImg);
				}catch(NumberFormatException e) {
					System.out.println("Mauvais nom famille skip file : " + fileName);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getElementImage(int elementSubType) {
		return elementMap.get(elementSubType);
	}
	
	public BufferedImage getFamilleImage(int elementSubType) {
		return familleMap.get(elementSubType);
	}
}
