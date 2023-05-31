package br.com.douglas.dadosempresainsertdata.entity;

import br.com.douglas.dadosempresainsertdata.enums.EnumPorteEmpresa;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "EMP_EMPRESA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "EMP_NM_CPNJ_BASE", length = 8)
    private String cnpjBase;
    @Column(name = "EMP_DS_RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "EMP_CD_NATUREZA_JURIDICA")
    private String naturezaJuridica;

    @Column(name = "EMP_DS_QUALIFICACAO_RESPONSAVEL")
    private String qualificacaoResponsavel;

    @Column(name = "EMP_VL_CAPITAL_SOCIAL")
    private Double capitalSocial;

    @Enumerated(EnumType.STRING)
    @Column(name = "EMP_CD_PORTE_EMPRESA")
    private EnumPorteEmpresa porteEmpresa;

    @Column(name = "EMP_DS_ENTE_FEDERATIVO")
    private String enteFederativo;

}
