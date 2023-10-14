import structures.AssociativeArray;


/**
 * An implementation of category with a name and an AssiaticeArray that maps image 
 * locations to text. It represents the mappings for a single page of items that 
 * should be displayed
 *
 * @author Alma Ordaz
 */
public class AACCategory {

   // +--------+------------------------------------------------------
   // | Fields |
   // +--------+

   /*
    * the name of the category
    */
   String name;

   /*
    * an associative array that maps image location to text
    */
   AssociativeArray<String, String> items;

   // +--------------+------------------------------------------------
   // | Constructors |
   // +--------------+

   /*
    * Creates a new empty category with the given name
    */
   public AACCategory(String name) {
      this.name = name;
      this.items = new AssociativeArray<String, String>();
   }// AACCategory

   // +---------+-----------------------------------------------------
   // | Methods |
   // +---------+

   /*
    * Adds the mapping of the imageLoc to the text to the category.
    */
   public void addItem(String imageLoc, String text) {
      this.items.set(imageLoc, text);
   }// addItem(String, String)

   /*
    * Returns the name of the category
    */
   public String getCategory() {
      return this.name;
   }// getCategory()

   /*
    * Returns the text associated with the given image loc in this category
    */
   public String getText(String imageLoc) throws Exception {
      return this.items.get(imageLoc);
   }// getText(String)

   /*
    * Determines if the provided images is stored in the category
    */
   public boolean hasImage(String imageLoc) {
      return this.items.hasKey(imageLoc);
   }// hasImage(String)

   /*
    * Returns an array of all the images in the category
    */
   public String[] getImages() {
      return this.items.getKeys();
   }// getImages()

}// class AACCategory
