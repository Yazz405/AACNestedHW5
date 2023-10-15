import java.io.File;
import java.io.PrintWriter;

import structures.AssociativeArray;

/**
 * An implementation that keeps track of the complete set of AAC mappings. It
 * will store the mapping of the images in the home page to AACCategories using the
 * categories field. There is a currentCategory that will keep track of the
 * category we are in, and finally a default category that represents the home category.
 * 
 * @author Alma Ordaz
 */
public class AACMappings {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * the name of the file
   */
  String filename;

  /*
   * represets the home category
   */
  AACCategory topLevelCategory;

  /*
   * keeps track of the category we are in
   */
  AACCategory currentCategory;

  /*
   * Associative array that maps images to AACCategorries
   */
  AssociativeArray<String, AACCategory> categories;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * creates a new AACMappings given the starting file name
   */
  public AACMappings(String filename) {
    this.filename = filename;

    this.topLevelCategory = new AACCategory("topLevelCategory");
    this.currentCategory = this.topLevelCategory;

    this.categories = new AssociativeArray<String, AACCategory>();

  }// AACMappings

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * Given the image location selected, it determines the associated text with the
   * image. If the image provided is a category, it also updates the AAC's current
   * category to be the category associated with that image.
   */
  public String getText(String imageLoc) {

    String result = "";

    try {
      result = this.currentCategory.getText(imageLoc);
      if (this.categories.hasKey(imageLoc)) {
        this.currentCategory = this.categories.get(imageLoc);
      } // if
    } catch (Exception e) {
      e.printStackTrace();
    }//try-catch
    return result;
  }// getText(String)

  /*
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {

    return this.currentCategory.getImages();
  } // getImageLocs()

  /*
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    this.currentCategory = this.topLevelCategory;
  }// reset()

  /*
   * Gets the current category, if the category is the topLevelCategory,
   * it returns an empty string.
   */
  public String getCurrentCategory() {

    if(this.currentCategory == this.topLevelCategory){
      return "";
    }//if
    else{
      return this.currentCategory.getCategory();
    }//else
  }//getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc) {
    return this.currentCategory == this.topLevelCategory;
  }// isCategory(String)

  /*
   * Writes the ACC mappings stored to a file.
   */
  public void writeToFile(String filename) {

    try {
      PrintWriter pen = new PrintWriter(new File(filename));
      String[] categoryNames = this.topLevelCategory.getImages();

      for(String current : categoryNames){
        pen.println(current + " " + this.topLevelCategory.getText(current));

        for(String item : this.categories.get(current).getImages()) {
          pen.println(">" + item + " " + this.categories.get(current).getText(item));
        }//for
      }//for

      pen.close();
    } catch (Exception e) {
      e.printStackTrace();
    }//try-catch
  }// writeToFile(String)

  /*
   * Adds the mapping to the current category (or the default category if that is
   * the current category)
   */
  public void add(String imageLoc, String text) {

    try {
      this.currentCategory.addItem(imageLoc, text);
      if (isCategory(imageLoc)) {
        this.categories.set(imageLoc, new AACCategory(text));
      } // if
    } catch (Exception e) {
      e.printStackTrace();
    } // try-catch
  }// add(String, String)

}//class AACMappings
