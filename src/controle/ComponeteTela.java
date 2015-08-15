package controle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Filme;

public class ComponeteTela {

	List<Filme> lista;

	public ComponeteTela() {
		try {
			lista = new ParseXML().criarDocumentoXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTable tabelaVazia() {
		JTable table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
		// aqui entraria o array de linhai
		// {"Exemplo","exemplo"}
				}, new String[] { "idFilme", "NomeFilme", "genero",
						"Classificação", "3D", "Duração"

				}));
		return table;
	}

	public JTable TabelaCheia() {
		JTable table = new ComponeteTela().tabelaVazia();
		DefaultTableModel valor = (DefaultTableModel) table.getModel();

		for (Filme filme : lista) {
			valor.addRow(new String[] { filme.getIdFilme().toString(),
					filme.getNomeFilme(), filme.getGenero(),
					filme.getClassificacaoEtaria(),
					filme.getExibicao3D().toString(),
					filme.getDuracao().toString() + "Minutos" });

		}
		return table;
	}

	public JTable TabelaFiltrada(String filtro) {
		JTable table = new ComponeteTela().tabelaVazia();
		DefaultTableModel valor = (DefaultTableModel) table.getModel();

		if (filtro == null||filtro.equalsIgnoreCase("Selecione uma Opção")) {
			table = TabelaCheia();
			return table;
		}

		for (Filme filme : lista) {
			if (filme.getGenero().equalsIgnoreCase(filtro)
					|| filme.getClassificacaoEtaria().equalsIgnoreCase(filtro)) {
				valor.addRow(new String[] { filme.getIdFilme().toString(),
						filme.getNomeFilme(), filme.getGenero(),
						filme.getClassificacaoEtaria(),
						filme.getExibicao3D().toString(),
						filme.getDuracao().toString() + "Minutos" });

			}
		}
		return table;
	}

	public Set<String> criarComboBox2(String filtro) {
		Set<String> setlista = new HashSet<String>();

		if (filtro.equalsIgnoreCase("Classificação Etaria")) {
			
			for (Filme lista1 : lista) {
				setlista.add(lista1.getClassificacaoEtaria());
			}
		} else if (filtro.equalsIgnoreCase("genero")) {
			
			for (Filme lista1 : lista) {
				setlista.add(lista1.getGenero());
			}
		}

		return setlista;

	}

}
