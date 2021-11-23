/*!
* Start Bootstrap - Agency v7.0.7 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/

//window.addEventListener('DOMContentLoaded', function(){ .. })  : HTML과 script가 로드된 시점에 발생하는 이벤트. onload 이벤트보다 먼저 발생하여 빠른 실행속도가 필요할때 적합
//$(document).ready(function(){ .. });  :  DOMContentLoaded의 jQuery 버전
function close() {
    document.querySelector(".background").className = "background";
}
// document.querySelector("#show").addEventListener("click", show);
document.querySelector("#close").addEventListener("click", close);
document.querySelector(".cta").addEventListener("click", setMyId);

function setMyId() {

    const userId = document.getElementById("myid").value;
    if (userId == '') {
        alert('올바른 ID를 입력해주세요!');
        return;
    }
    console.log('당신의 id는 '+userId+ '입니다.');
    close();
    // 서버에게 userId값 전달 요청
    getAPI(userId);
    // 웹 로컬db에 저장

    // 페이지 로드
    // widow.location=`/home/${myId}`;
    // window.location.reload();
}
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


function getAPI(userId) {
    // 보이지 않는 요청
    $.ajax({
        type:"GET",
        url:'/setId/'+userId,
        timeout:5000,
    }).then(
        (response)=> {
            const stringData = JSON.stringify(response);     // [object Object] -> string: {"nowEmotion":1,"adId":19,"emotion2":232,"emotion1":21,"emotion0":11}
            const parseData = JSON.parse(stringData);       // string -> json 객체
            console.log('******************************');
            console.log(parseData.nowEmotion);
            console.log(parseData.adId);
            console.log(parseData.emotion0);
            console.log(parseData.emotion1);
            console.log(parseData.emotion2);

            alert('userId의 emotion&adId 조회 성공! nowEmotion = ' + parseData.nowEmotion + ', 광고ID = ' + parseData.adId);
            // $.ajax({
            //     type: "GET",
            //     url: '/home',
            //
            // })
            // 여기서 index.mustache로 값을 전달하는 방법
            window.location.href= "/home/response";
            // window.location.href = "/home/"+response.userId;
        },
        (error) => {
            alert("서버 응답 실패");
            window.location.href = "/modal";
        }
    )
}
window.addEventListener('DOMContentLoaded', event => {
    document.querySelector(".background").className = "background show";

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

// var mapContainer = document.getElementById('map'), // 지도를 표시할 div
//     mapOption = {
//         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };
// // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
// var map = new kakao.maps.Map(mapContainer, mapOption);