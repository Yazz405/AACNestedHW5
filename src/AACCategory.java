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
   }// addItem

   /*
    * Returns the name of the category
    */
   public String getCategory() {
      return this.name;
   }// getCategory

   /*
    * Returns the text associated with the given image loc in this category
    */
   public String getText(String imageLoc) throws Exception {
      return this.items.get(imageLoc);
   }// getText

   /*
    * Determines if the provided images is stored in the category
    */
   public boolean hasImage(String imageLoc) {
      return this.items.hasKey(imageLoc);
   }// hasImage

   /*
    * Returns an array of all the images in the category
    */
   public String[] getImages() {
      return this.items.getKeys();
   }// getImages


   // public static void main(String[] args) throws Exception{

   //    AACCategory test = new AACCategory("start");
   //    test.addItem("loc1", "bannana");
   //    test.addItem("loc2", "strawberry");
   //    test.addItem("loc3", "cherry");

   //    String[] helper = test.getImages();

   //    for (int i = 0; i < helper.length; i++) {
   //       System.out.println("helper: " + helper[i]);
   //    }

   //    System.out.println(test.getCategory());
   //    System.out.println(test.getText("loc2"));
   //    System.out.println(test.hasImage("loc4"));

   // }// main

}// class AACCategory
