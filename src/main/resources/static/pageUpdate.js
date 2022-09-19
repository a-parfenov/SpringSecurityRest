async function pageUpdate(event) {

    // Если функция вызвана без аргументов:
    if (typeof event == 'undefined') {
        $('body a[href]').click(pageUpdate);
    }
    // Если функция вызвана в результате клика по ссылке:
    else {
        const link = event.target.href;
        console.log(link)

        if (new URL(link)['host'] == location.host) {
            event.preventDefault();  // Предотвращаем переход
            $('body').css('pointer-events', 'none');  // Блокируем страницу

            // const hide = $('body').animate({opacity: 0.2}, 500).promise();
            const ajax = $.ajax(link); // Запускаем загрузку новой страницы
            // await hide; // Ждем окончания анимации исчезновения

            // Вставляем данные на страницу беря их с ново-скачанной страницы:
            const doc = new DOMParser().parseFromString((await ajax), 'text/html');
            const html = $('body', doc).html();
            $('body').html(html);

            // Скролим в самый вверх:
            $('body, html').animate({scrollTop: 0}, 0);

            // Меняем адрес в адресной строке:
            history.pushState(null, null, link);
            pageUpdate();
            await $('body').animate({ opacity: 1 }, 500).promise();

            // Снимаем блокировку с документа:
            $('body').css('pointer-events', '');
        }
    }
}

pageUpdate();
