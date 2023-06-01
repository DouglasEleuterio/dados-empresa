package br.com.douglas.dadosempresainsertdata.entity;

import br.com.douglas.dadosempresainsertdata.enums.EnumPorteEmpresa;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "EMP_EMPRESA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "EMP_NM_CPNJ_BASE", length = 8)
    @CsvBindByPosition(position = 0)
    private String cnpjBase;

    @Column(name = "EMP_DS_RAZAO_SOCIAL")
    @CsvBindByPosition(position = 1)
    private String razaoSocial;

    @Column(name = "EMP_CD_NATUREZA_JURIDICA")
    @CsvBindByPosition(position = 2)
    private String naturezaJuridica;

    @Column(name = "EMP_DS_QUALIFICACAO_RESPONSAVEL")
    @CsvBindByPosition(position = 3)
    private String qualificacaoResponsavel;

    @Column(name = "EMP_VL_CAPITAL_SOCIAL")
    @CsvBindByPosition(position = 4)
    private Double capitalSocial;

    @Enumerated(EnumType.STRING)
    @Column(name = "EMP_CD_PORTE_EMPRESA")
    @CsvBindByPosition(position = 5)
    private EnumPorteEmpresa porteEmpresa;

    @Column(name = "EMP_DS_ENTE_FEDERATIVO")
    @CsvBindByPosition(position = 6)
    private String enteFederativo;
}
