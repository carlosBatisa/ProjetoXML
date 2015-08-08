package controle;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import entity.Filme;

public class ParseXML {

	Document doc;

	public List<Filme> criarDocumentoXML() throws Exception {

		URL url = new URL("http://www.cinemark.com.br/mobile/xml/films/");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//descompactando o arquivo zip http copressor...
		InputStream ism = url.openStream();
		GZIPInputStream gis = new GZIPInputStream(ism);
		Reader decoder = new InputStreamReader(gis);
		InputSource is = new InputSource(decoder);

		doc = db.parse(is);
		
		//populando a lista de filmes com doc...
		NodeList filmes = doc.getElementsByTagName("film");
		List<Filme> listaFimes = new ArrayList<Filme>();
		Filme f = new Filme();
				
		for (int i = 0; i < filmes.getLength(); i++) {
			Element filmeElemento = (Element) filmes.item(i);
			f.setIdFilme(new Integer(filmeElemento.getAttribute("id")));
			f.setNomeFilme(filmeElemento.getTextContent());
			f.setGenero(filmeElemento.getAttribute("genre"));
			f.setClassificacaoEtaria(filmeElemento
					.getAttribute("parent-guide-rating"));
			f.setExibicao3D(new Boolean(filmeElemento.getAttribute("media-3d")));
			f.setDuracao(new Integer(filmeElemento.getAttribute("runtime")));
			
			listaFimes.add(f);

		}
		return listaFimes;
	}

}
