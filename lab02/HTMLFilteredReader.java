/**
 * This program will read the contents of the url(with html codes) and print its contents(without html codes)
 * and the number of lines it contains, on the console. 
 * @auhtor Ahmet Faruk Ulutaþ
 * @date 01/03/2020
 */
public class HTMLFilteredReader extends MySimpleURLReader {
   
   // properties
   
   // constructors
   public HTMLFilteredReader( String url) {
      
      super( url);
   }
   
   // methods
   
   /* this method returns the text from an HTML file by removing 
    * all HTML code.
    * @return finalContent
    */
   public String getPageContents() {
      
      String content, finalContent;
      int index;
      
      content = super.getPageContents();
      finalContent = "";
      index = 0;
      
      while ( index < content.length() ) {
         
         // runs until end of the html codes
         while( content.charAt( index) == '<' || content.charAt(index) == '&' ) {
            
            // increase index until the closing tag is found
            if( content.charAt( index) == '<' ) {
               
               do {
                  index++;
                  
                  // closing tag is found
               } while( content.charAt( index) != '>' );
            }
            
            // increase index until end of the quotation tag is found
            else if( content.charAt( index) == '&' ) {
               
               do {
                  index++;
                  
                  // end of quotation tag is found
               } while( content.charAt( index) != ';' );
            }
            
            index++;
         }
         
         // it is not html code so write them into the finalContent
         finalContent = finalContent + content.charAt( index);
         
         // then increase the index
         index++;
      }
      
      return finalContent;
   }
   
   /* This method called to return the original page contents
    * @reutrn super.getPageContents(); parent class content method
    */
   public String getUnfilteredPageContents() {
      
      return super.getPageContents();
   }
   
}