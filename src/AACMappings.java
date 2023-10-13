import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * An implementation that keeps track of the complete set of AAC mappings. It
 * will
 * store the mapping of the images in the home page to AACCategories using the
 * categories field. There is a currentCategory that will keep track of the
 * category
 * we are in, and finally a default category that represents the home category.
 * 
 * @author Alma Ordaz
 */
public class AACMappings {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * represets the home category
   */
  AACCategory defaultCategory;

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
    this.currentCategory = new AACCategory(filename);
    this.defaultCategory = new AACCategory(filename);

    this.categories = new AssociativeArray<String, AACCategory>();

  }// AACMappings

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * Given the image location selected, it determines the associated text with the
   * image.
   * If the image provided is a category, it also updates the AAC's current
   * category to be
   * the category associated with that image
   */
  public String getText(String imageLoc) {

    try{
      // if the image is a category
    if (isCategory(imageLoc)) {
System.out.println("here");
      this.currentCategory = this.categories.get(imageLoc);
      return this.categories.get(imageLoc).getCategory();
    } // if

    return this.currentCategory.getText(imageLoc);
    } catch (Exception e){
      return "exception";
    }

  }// getText()

  /*
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {


    // return this.currentCategory.getImages();

    return new String[] { "img/food/icons8-french-fries-96.png",
        "img/food/icons8-watermelon-96.png" }; // STUB
  } // getImageLocs()

  /*
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {

    this.currentCategory = this.defaultCategory;
  }// reset

  /*
   * Gets the current category
   */
  public String getCurrentCategory() {

    return this.currentCategory.getCategory();
    // return "food"; // STUB
  }

  /*
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc) {
    // return this.categories.hasKey(imageLoc);
    return true;
  }// isCategory

  /*
   * Writes the ACC mappings stored to a file.
   */
  public void writeToFile(String filename) {
    // stub
  }// writeToFile

  /*
   * Adds the mapping to the current category (or the default category if that is
   * the current category)
   */
  public void add(String imageLoc, String text) {
    this.currentCategory.addItem(imageLoc, text);
  }// add

}
