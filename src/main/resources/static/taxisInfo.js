const taxisInfo = () => {

    async function apiTaxis() {
      const response = await fetch('api/taxis', {
        method: 'GET',
        headers: {
        'Content-Type': 'application/json'
        }
      });
      const taxis = await response.json();
      const taxisContent = taxis.content;

      console.log(taxisContent)

        let listadoHtml = '';
        for (let taxi of taxisContent) {
          let taxiHtml = '<tr><td>' + taxi.id + '</td><td>' + taxi.license + '</td></tr>';
          listadoHtml += taxiHtml;
        }

      document.querySelector('#dataTable tbody').innerHTML = listadoHtml;
    }

    apiTaxis();

}

