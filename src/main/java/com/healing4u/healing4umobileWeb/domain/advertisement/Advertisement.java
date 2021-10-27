package com.healing4u.healing4umobileWeb.domain.advertisement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name="advertisement")
@Entity
public class Advertisement {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ad_id", nullable = false)
    private long adId;

    @Column(nullable = false)
    private int emotion;

    @Column(nullable = false)
    private int season;

    @Column(length = 50, nullable = false)
    private String serviceName;

    @Column(length = 25)
    private String address;

    @Column(name="detail_long", length = 1000, nullable = false)
    private String detailLong;

    @Column(length = 20)
    private String tel;

    @Column(name="kakaomap_url", length = 200, nullable = false)
    private String kakaoMapUrl;

    @Column(length = 200, nullable = false)
    private String src;
}
