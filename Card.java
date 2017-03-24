import javax.swing.ImageIcon;

public class Card extends javax.swing.JLabel
{
   String code = "";
   
   public Card(String cardCode)
   {  
      ImageIcon im = new ImageIcon(cardCode + ".gif");
      int c = 0;
      do
      { c++;
      } while (c<100000 && im.getImageLoadStatus()!=java.awt.MediaTracker.COMPLETE);  
      this.setIcon(im);
      code = cardCode;
   }
   
   public Card(String cardCode,int x,int y,int w,int h,EasyApp app)
   {
      ImageIcon im = new ImageIcon(cardCode + ".gif");
      int c = 0;
      do
      { c++;
      } while (c<100000 && im.getImageLoadStatus()!=java.awt.MediaTracker.COMPLETE);    
      this.setIcon(im);
      addTo(x,y,w,h,app);
      code = cardCode;
   }

   public void addTo(int x,int y,int w,int h,EasyApp app)
   {
       app.add(this);
       this.setBounds(x,y,w,h);
       if (app!=null)this.addMouseListener(app);
   }

}
