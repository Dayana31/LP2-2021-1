
package pe.edu.pucp.lp2soft.main;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 *
 * @author DAYANA
 */
public class NoHeaderObjectOuputStream extends ObjectOutputStream{
    public NoHeaderObjectOuputStream(BufferedOutputStream bos)
    throws Exception{
        super(bos);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
