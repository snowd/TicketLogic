package com.snowd.ticketlogic;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView text = (TextView) findViewById(R.id.main_text);
		String content = getHtmlString(html);
		text.setText(content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private String getHtmlString(String src) {
		String str = Html.fromHtml(src).toString();
		Log.d("", "content=" + str);
		try {
			List<LeftTicketState> list = LeftTicketState.createListFromHtml(html);
			for (int i = 0; i < list.size(); i++) {
				Log.d("", list.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	String html = "0,<span id='id_880000K1740K' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K1740K#XXO#XAY') onmouseout='onStopOut()'>K174</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;09:00,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;21:58,12:58,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K174#12:58#09:00#880000K1740K#XXO#XAY#21:58#西宁西#西安#01#09#1*****33654*****00001*****00003*****0000#983435D2693BA578CBAE8002E4873F1F8ACF5FA4E70F4F8157FFBD9E#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n1,<span id='id_880000T1660A' class='base_txtdiv' onmouseover=javascript:onStopHover('880000T1660A#XXO#XAY') onmouseout='onStopOut()'>T166</span>,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;10:00,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;20:49,10:49,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<a class='btn130' style='text-decoration:none;'>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n2,<span id='id_880000T2660B' class='base_txtdiv' onmouseover=javascript:onStopHover('880000T2660B#XXO#XAY') onmouseout='onStopOut()'>T266</span>,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;10:52,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;21:20,10:28,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('T266#10:28#10:52#880000T2660B#XXO#XAY#21:20#西宁西#西安#04#06#1*****30794*****00001*****00003*****0000#BE0CF0AA264F50BCED05A72DBC2EB6837D8DD8CB3C3D454E9BBBD76A#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n3,<span id='id_880000T1520F' class='base_txtdiv' onmouseover=javascript:onStopHover('880000T1520F#XXO#XAY') onmouseout='onStopOut()'>T152</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;13:50,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;01:12,11:22,--,--,--,--,--,20,<font color='#008800'>有</font>,--,<font color='#008800'>有</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('T152#11:22#13:50#880000T1520F#XXO#XAY#01:12#西宁西#西安#01#09#1*****33104*****00201*****04543*****0299#75F0FBAE87ED6BB5A825510CE94F005969060E2CCEAE3E00AD4AF2FB#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n4,<span id='id_880000K89005' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K89005#XXO#XAY') onmouseout='onStopOut()'>K890</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;20:00,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;08:45,12:45,--,--,--,--,--,16,<font color='#008800'>有</font>,--,<font color='#008800'>有</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K890#12:45#20:00#880000K89005#XXO#XAY#08:45#西宁西#西安#01#11#1*****34344*****00161*****07503*****0233#B3D4E3BDA088F46DDD06B1D65178A70FC2BCF62B448DA1E94DD7836E#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n5,<span id='id_880000K62204' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K62204#XXO#XAY') onmouseout='onStopOut()'>K622</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;20:25,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;08:27,12:02,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K622#12:02#20:25#880000K62204#XXO#XAY#08:27#西宁西#西安#01#06#1*****34344*****00001*****00003*****0000#0202B01E18B77B42A10D4DD9E06EECD4F74ABB116FC0C8F139DFA886#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n6,<span id='id_88000K101004' class='base_txtdiv' onmouseover=javascript:onStopHover('88000K101004#XXO#XAY') onmouseout='onStopOut()'>K1010</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;21:15,<img src='/otsweb/images/tips/last.gif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;09:53,12:38,--,--,--,--,--,<font color='#008800'>有</font>,<font color='#008800'>有</font>,--,<font color='#008800'>有</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K1010#12:38#21:15#88000K101004#XXO#XAY#09:53#西宁西#西安#01#13#1*****34344*****00231*****06533*****0410#B89D3E3597300E680D75739373B8AABBF267C6934D353070723D002C#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>\n7,<span id='id_880000K3780D' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K3780D#XXO#XAY') onmouseout='onStopOut()'>K378</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;22:15,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;10:25,12:10,--,--,--,--,--,16,<font color='#008800'>有</font>,--,<font color='#008800'>有</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K378#12:10#22:15#880000K3780D#XXO#XAY#10:25#西宁西#西安#01#10#1*****34344*****00161*****06793*****0340#CB110EA5535ABFC0F9CB3B1789BEA807B8808E04D36C73144F5CA654#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>";
//	String html = "0,<span id='id_880000K1740K' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K1740K#XXO#XAY') onmouseout='onStopOut()'>K174</span>,<img src='/otsweb/images/tips/first.gif'>&nbsp;&nbsp;&nbsp;&nbsp;西宁西&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;09:00,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;西安&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;21:58,12:58,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K174#12:58#09:00#880000K1740K#XXO#XAY#21:58#西宁西#西安#01#09#1*****33654*****00001*****00003*****0000#983435D2693BA578CBAE8002E4873F1F8ACF5FA4E70F4F8157FFBD9E#O1')>预&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订</a>";
//	String html = "0,<span id='id_880000K1740K' class='base_txtdiv' onmouseover=javascript:onStopHover('880000K1740K#XXO#XAY') onmouseout='onStopOut()'>K174</span>,<img src='/otsweb/images/tips/first.gif'>西宁西<br>09:00,西安<br>21:58,12:58,--,--,--,--,--,<font color='darkgray'>无</font>,<font color='darkgray'>无</font>,--,<font color='darkgray'>无</font>,<font color='#008800'>有</font>,--,<a name='btn130_2' class='btn130_2' style='text-decoration:none;' onclick=javascript:getSelected('K174#12:58#09:00#880000K1740K#XXO#XAY#21:58#西宁西#西安#01#09#1*****33654*****00001*****00003*****0000#983435D2693BA578CBAE8002E4873F1F8ACF5FA4E70F4F8157FFBD9E#O1')>预订</a>\n";

}
