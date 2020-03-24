package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Listitem> listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listitems = new ArrayList<>();

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        listitems.add(new Listitem("https://r2---sn-po4g5uxa-5hql.googlevideo.com/videoplayback?expire=1584997691&ei=2tB4Xs3qOcC5z7sP0oWXwAU&ip=45.126.147.245&id=o-APwzA6uW38xyqt4gcTbNLvKLxPDI3kc5_ONMHB2lNX1T&itag=251&source=youtube&requiressl=yes&mh=bK&mm=31%2C29&mn=sn-po4g5uxa-5hql%2Csn-cvh7knek&ms=au%2Crdu&mv=m&mvi=1&pl=24&gcr=in&initcwndbps=558750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3075560&dur=190.661&lmt=1575231584914266&mt=1584975995&fvip=5&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ABSNjpQwRQIgfem9-pkWCeasUzdugtPQDD6rI0gp0h7pA3P_k2x2GqYCIQDdYfyca_dPqYbwuFMhgW5GQMP903HmzzDRY5B92tO1uw%3D%3D&sig=ADKhkGMwRgIhAMgJ8K_riI2XUg4nK9g-1HZcw-smzpBZX3y4Ep2aJcArAiEA_3dlN77kGlfIolG8J4z71m3lSMFTYYKjvW-JRycMDvQ=&ratebypass=yes",
                "talobrothers - Summer Air",
                "https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "ItaloBrothers",
                "191"));

        /*for (int i = 0; i<5; i++){
            Listitem listitem = new Listitem(

                    "hfhjfs",
                    "sdsdsdsd",
                    "dssdsd",
                    "sdsdsd",
                    "190"
            );
            listitems .add(listitem);

        }*/

        adapter = new Myadapter(listitems,this);
        recyclerView.setAdapter(adapter);

    }
}
