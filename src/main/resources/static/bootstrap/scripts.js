/*!
* Start Bootstrap - Agency v7.0.7 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {
    // modal popup
    document.querySelector('.popup-container').className += ' active';

    // x버튼
    document.querySelector('.close').addEventListener('click', function () {
        document.querySelector('.popup-container').classList.remove('active');
    });

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });
});

// myId값 설정하는 함수
function setMyId() {
    let myId = document.getElementById('myid').value;
    if (myId == '') {
        alert('올바른 ID를 입력해주세요!');
        return;
    }
    alert('당신의 id는 '+myId+ '입니다.');
    // 웹 로컬db에 저장


    // 페이지 로드
    // widow.location=`/home/${myId}`;
    window.location.reload();
    // $.ajax({
    //     type: 'GET',
    //     url: `/home/${userId}`,
    //     success: function(response) {
    //         document.querySelector('.popup-container').classList.remove('active');
    //         alert('성공적으로 등록되었습니다!');
    //
    //         //여기서 다시 백엔드에 다른 api 호출
    //         widow.location.reload();   // 백엔드에서 해당 요청이 왔을때 db조회를 해서 response로 전달
    //     }
    // })
}

// var mapContainer = document.getElementById('map'), // 지도를 표시할 div
//     mapOption = {
//         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };
// // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
// var map = new kakao.maps.Map(mapContainer, mapOption);