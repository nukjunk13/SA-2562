<template>
  <v-app>
    <v-app-bar app class="orange darken-2">
      <v-toolbar-title class="headline text-uppercase" >
        <span>ADVERTISEMENT</span>

      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >

      </v-btn>
    </v-app-bar>

    <v-content>
      <Advertisement/>
    </v-content>
  </v-app>
</template>

<script>
import Advertisement from './components/Advertisement';

export default {
  name: 'App',
  components: {
    Advertisement
  },
  data: () => ({
    //
  }),
};
</script>
