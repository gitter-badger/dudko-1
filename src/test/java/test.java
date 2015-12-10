import com.barsu.instagram.api.utils.Methods;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 02.12.2015.
 */
public class test {
    public static void main(String[] args) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        String url = Methods.SELF_MEDIA+"?access_token=1407815566.4121277.feefe4d1f4c8488ebb2df6e98aa7a292";
        System.out.println(url);
        HttpGet httppost = new HttpGet(url);

        try {
          /* List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("ACCESS_TOKEN", "1407815566.4121277.feefe4d1f4c8488ebb2df6e98aa7a292"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
*/
            HttpResponse response = httpclient.execute(httppost);

            String responseString = new String();
            HttpEntity responseEntity = response.getEntity();
            if(responseEntity!=null) {
                responseString = EntityUtils.toString(responseEntity);
            }
            System.out.println(responseString);

        } catch (ClientProtocolException e) {
            // Ошибка :(
        } catch (IOException e) {
            // Ошибка :(
        }
    }
}
