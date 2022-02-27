<script>
import ItemServices from '../services/ItemServices'
export default{
    name: "home-view",
    data(){
        return{
            items: null
        }
    },
    methods: {
        getItems(){
            ItemServices.getItems().then((response)=>{
                this.items = response.data;
            })
            .catch((error) => {
                alert(error);
            });
        }
    },
    mounted(){
        this.getItems();
    }
};
</script>

<template>
<div>
  <h1>Dishes</h1>
  <ul class="list-group">
    <li v-for="item in items" :key="item.name" class="list-group-item">
      {{item.name}}
      <img v-bind:src="item.imageUrl" class="img-fluid" width="150" height="150">
    </li>
  </ul>
</div>
</template>
